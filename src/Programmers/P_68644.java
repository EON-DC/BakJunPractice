package Programmers;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_68644 {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        // numbers array 중 2개를 조합으로 뽑고, 이에 대한 결과를 set에 담으면 중복이 제거됨.
        // int[] 담아 오름차순으로 반환한다.
        boolean[] visited = new boolean[numbers.length];
        Set<Integer> result = new HashSet<>();
        combination(numbers, visited, 0, numbers.length, 2, result);
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }

    static public void combination(int[] numbers, boolean[] visited, int start, int N, int r, Set<Integer> result) {
        if (r == 0) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    temp += numbers[i];
                }
            }
            result.add(temp);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(numbers, visited, i + 1, N, r - 1, result);
                visited[i] = false;
            }
        }

    }
}
