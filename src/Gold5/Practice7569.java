package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Practice7569 {
}

class Main {

    static int map[][][];

    static int M, N, H;

    static Queue<Node> queue = new LinkedList<>();

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        H = Integer.parseInt(line[2]);

        map = new int[N][M][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                line = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    map[j][k][i] = Integer.parseInt(line[k]);
                    if (map[j][k][i] == 1) {
                        queue.add(new Node(j, k, i));
                    }
                }
            }
        }

        System.out.println(BPS());
    }

    public static int BPS() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                int cz = node.z + dz[i];

                if (cx >= 0 && cx < N && cy >= 0 && cy < M && cz >= 0 && cz < H
                        && map[cx][cy][cz] == 0) {
                    queue.add(new Node(cx, cy, cz));
                    map[cx][cy][cz] = map[node.x][node.y][node.z] + 1;
                }
            }
        }

        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 0) {
                        return -1;
                    }
                    maxDay = Math.max(maxDay, map[i][j][k]);
                }
            }
        }

        if (maxDay == 1) {
            return 0;
        }
        return maxDay - 1;
    }


}
