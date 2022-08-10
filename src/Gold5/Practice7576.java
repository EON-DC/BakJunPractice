package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice7576 {

    static int row, col;
    static int map[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        col = Integer.parseInt(token.nextToken());
        row = Integer.parseInt(token.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < row && cy < col) {
                    if (map[cx][cy] == 0) {
                        queue.add(new int[]{cx, cy});
                        map[cx][cy] = map[x][y] + 1;
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        if (result == 1) {
            return 0;
        } else
            return result - 1;
    }

}
