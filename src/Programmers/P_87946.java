package Programmers;

import java.util.ArrayList;

public class P_87946 {

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> buffer = new ArrayList<>();
        boolean[] visited = new boolean[dungeons.length];
        permutation(dungeons.length, dungeons.length, visited, list, buffer);

        int maxCount = 0;
        Outer:
        for (String s : list) {
            int copyK = k;
            char[] chars = s.toCharArray();
            int count = 0;
            for (int i = 0; i < dungeons.length; i++) {
                int order = chars[i] - '0';
                int minNeed = dungeons[order][0];
                int usage = dungeons[order][1];
                if (copyK >= minNeed) {
                    count++;
                    copyK -= usage;
                } else {
                    maxCount = Math.max(maxCount, count);
                    continue Outer;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    // permutation 0~7까지 순서 조합을 리스트로 만들어 보관
    // 탐색은 그 순서에 맞게 시행한다. 만약 시행 중 k 가 오링나는 경우엔 탐색한 개수를 maxCount와 비교하여 저장
    // maxCount return한다.
    public static void permutation(int n, int r, boolean[] visited, ArrayList<String> list, ArrayList<String> buffer) {
        if (r == buffer.size()) {
            String temp = "";
            for (String s : buffer) {
                temp += s;
            }
            list.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer.add(String.valueOf(i));
                permutation(n, r, visited, list, buffer);
                buffer.remove(buffer.size() - 1);
                visited[i] = false;
            }
        }

    }
}
