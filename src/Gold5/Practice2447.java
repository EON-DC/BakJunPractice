package Gold5;

import java.io.*;

public class Practice2447 {

    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void star(int x, int y, int N, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }
        if (N == 1) {
            map[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, N / 3, true);
                } else {
                    star(i, j, N / 3, false);
                }
            }
        }
    }
}