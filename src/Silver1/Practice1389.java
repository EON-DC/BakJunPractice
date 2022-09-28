package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Practice1389 {
    static int map[][];
    static boolean[] visited;

    static int N;
    static int result;
    static int minCount = Integer.MAX_VALUE;

    static class Bacon {
        int num;
        int value;

        public Bacon(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        map = new int[N + 1][N + 1];

        while (M-- > 0) {
            line = br.readLine().split(" ");
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);
            save(row, col);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        System.out.println(result);
    }

    public static void save(int row, int col) {
        map[row][col] = 1;
        map[col][row] = 1;
    }

    public static void BFS(int start) {
        Queue<Bacon> queue = new LinkedList<>();
        int count = 0;

        visited[start] = true;
        queue.offer(new Bacon(start, 0));

        while (!queue.isEmpty()) {
            Bacon bacon = queue.poll();
            count += bacon.value;

            for (int i = 1; i <= N; i++) {
                int num = map[bacon.num][i];
                if (num == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Bacon(i, bacon.value + 1));
                }
            }
        }

        if (minCount > count) {
            minCount = count;
            result = start;
        }
    }
}

