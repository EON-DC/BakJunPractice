package Programmers;

import java.util.*;

public class P_77484 {

    public static void main(String[] args) {
        int[] answer = solution();
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }

    static public int[] solution() {
        int[] answer = {};
        // 브루트포스, 1~45까지 0개의 빈칸만큼 뽑아 등수를 검증했을 때, max와 min을 ans에 담아 제출
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        // 사용된 숫자들을 ArrayList로 담아둔다

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                list.add(lottos[i]);
            }
        }
        int zeroCount = 6 - list.size();  // zeroCount 가 remain으로 쓰일 예정

        int[] enableNum = new int[45 - list.size()];
        int index = 0;
        for (int i = 1; i <= 45; i++) {
            if (list.contains(i)) {
                continue;
            }
            enableNum[index] = i;
            index++;
        }
        boolean[] visited = new boolean[45 - list.size()];
        Set<Integer> ranks = new HashSet<>();
        combination(enableNum, visited, 0, enableNum.length, zeroCount, win_nums, ranks, list);
        answer = new int[2];
        answer[0] = Collections.min(ranks).intValue();
        answer[1] = Collections.max(ranks).intValue();

        return answer;
    }

    public static void combination(int[] enableNum, boolean[] visited, int start, int N, int r,
                                   int[] win_nums, Set<Integer> ranks, ArrayList<Integer> list) {
        if (r == 0) {
            int[] makedArr = arrayMaker(enableNum, visited, N, list);
            int rank = verify(makedArr, win_nums);
            ranks.add(rank);
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(enableNum, visited, i + 1, N, r - 1, win_nums, ranks, list);
                visited[i] = false;
            }
        }
    }

    public static int[] arrayMaker(int[] enableNum, boolean[] visited, int N, ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                result.add(enableNum[i]);
            }
        }
        result.addAll(list);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    public static int verify(int[] makedArr, int[] win_nums) {
        // rank 제출
        int sameCount = 0;
        for (int i = 0; i < 6; i++) {
            int testNum = makedArr[i];
            for (int j = 0; j < 6; j++) {
                if (testNum == win_nums[j]) {
                    sameCount++;
                }
            }
        }
        switch (sameCount) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }

    }


}