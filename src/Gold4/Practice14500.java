package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice14500 {

    static int row, col, result;


    static int map[][];
    static boolean[][] visited;


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);

        map = new int[row][col];
        visited = new boolean[row][col];


        for (int i = 0; i < row; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 0, 0, visited);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(result);


    }

    /**
     * 거리가 4가 될 때까지 DFS 탐색, 거리가 4될 경우 점수 계산 후 종료
     */
    public static void dfs(int x, int y, int sum, int length, boolean[][] visited) {
        if (length == 4) {
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = dx[i] + x;
            int cy = dy[i] + y;
            if (verify(cx, cy) && !visited[cx][cy]) {
                if (length == 2) {
                    visited[cx][cy] = true;
                    dfs(x, y, sum + map[cx][cy], length + 1, visited);
                    visited[cx][cy] = false;
                }
                visited[cx][cy] = true;
                dfs(cx, cy, sum + map[cx][cy], length + 1, visited);
                visited[cx][cy] = false;
            }
        }
    }

    /**
     * 주어진 좌표가 map 내부에 존재하는지 확인
     */
    public static boolean verify(int cx, int cy) {
        if (cx >= 0 && cx < row && cy >= 0 && cy < col) {
            return true;
        }
        return false;
    }

}