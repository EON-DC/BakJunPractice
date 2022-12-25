import java.util.*;

public class selfStudyDFS {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 1, 2, 3});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static public int[] solution(int[] answers) {
        int[] answer = {};
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < no2.length; i++) {

        }
        int no1Count = 0;
        int no2Count = 0;
        int no3Count = 0;

        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            int no1Collect = no1[i % 5];
            int no2Collect = no2[i % 8];
            int no3Collect = no3[i % 10];
            if (ans == no1Collect) {
                no1Count++;
            }
            if (ans == no2Collect) {
                no2Count++;
            }
            if (ans == no3Collect) {
                no3Count++;
            }
        }
        // 같은지 비교
        Set<Integer> set = new HashSet<>();
        set.add(no1Count);
        set.add(no2Count);
        set.add(no3Count);
        ArrayList<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1, no1Count});
        list.add(new Integer[]{2, no2Count});
        list.add(new Integer[]{3, no3Count});
        Collections.sort(list, new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1].intValue() != o2[1].intValue()) {
                    return o2[1] - o1[1]; // 점수 높은 순으로 내림차순
                } else {
                    return o1[0] - o2[0]; // 점수 같을 경우 수포자 오름차순
                }


            }
        });
        if (set.size() == 3) {
            // 겹치지 않으므로 max 1개만 고르면 됨
            answer = new int[]{list.get(0)[0]};

        } else if (set.size() == 2) {
            // 크기 비교해서 큰 것 1개 또는 2개 제출
            if (list.get(0)[1] == list.get(1)[1]) {
                answer = new int[]{list.get(0)[0], list.get(1)[0]};
            } else {
                answer = new int[]{list.get(0)[0]};
            }

        } else if (set.size() == 1) {
            // 셋 다 같은 상황이므로 1,2,3 제출
            answer = new int[]{1, 2, 3};
        }


        return answer;
    }
}
