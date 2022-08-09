package Silver2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1012_BFS {
    static int M, N, K, count;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int map[][];
    static boolean visited[][];

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int tempx = queue.peek()[0];
            int tempy = queue.peek()[1];
            visited[tempx][tempy] = true;
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = tempx + dx[i];
                int cy = tempy + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    if (!visited[cx][cy] && map[cx][cy] == 1) {
                        queue.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            for (int j = 0; j < K; j++) {
                token = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(token.nextToken());
                int tempY = Integer.parseInt(token.nextToken());
                map[tempX][tempY] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}