package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n + 1][n + 1];
        for (int[] pair : wires) {
            map[pair[0]][pair[1]] = 1;
            map[pair[1]][pair[0]] = 1;
        }
        int a, b;
        for (int i = 0; i < wires.length; i++) {
            int[] pair = wires[i];
            a = pair[0];
            b = pair[1];

            map[a][b] = 0;
            map[b][a] = 0;

            int areaCnt = bfs(n, a, map);
            answer = Math.min(answer, areaCnt);

            map[a][b] = 1;
            map[b][a] = 1;

        }

        return answer;
    }

    public static int bfs(int n, int start, int[][] map) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int unit = queue.poll();
            visited[unit] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[unit][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int) Math.abs(n - cnt - cnt);
    }
}

