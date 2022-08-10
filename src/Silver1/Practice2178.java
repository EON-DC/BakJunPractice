package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice2178 {
    static int N, M;
    static int map[][];
    static int dist[][];

    static int dN[] = {1, 0, -1, 0};
    static int dM[] = {0, 1, 0, -1};
    static void bfs(int n, int m) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{n, m});
        while (!queue.isEmpty()) {
            int tempN = queue.peek()[0];
            int tempM = queue.peek()[1];
            queue.poll();

            if (tempN == N - 1 && tempM == M - 1) {
                return;
            } else {
                for (int i = 0; i < 4; i++) {
                    int CN = tempN + dN[i];
                    int CM = tempM + dM[i];
                    if (CN >= 0 && CM >= 0 && CN < N && CM < M) {
                        if (map[CN][CM] == 1 && dist[CN][CM] == -1) {
                            queue.add(new Integer[]{CN, CM});
                            dist[CN][CM] = dist[tempN][tempM] + 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - 48;
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1] + 1);
    }
}