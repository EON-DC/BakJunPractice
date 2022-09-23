package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice2630 {

    static int wc, bc;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        find(0, 0, size);

        System.out.println(wc);
        System.out.println(bc);
    }

    public static void find(int x, int y, int N) {
        if (N == 1) {
            if (map[x][y] == 1) {
                bc++;
            } else {
                wc++;
            }
            return;
        }
        boolean isAllSame = true;
        int unit = map[x][y];

        Outer:
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (unit != map[i][j]) {
                    isAllSame = false;
                    break Outer;
                }
            }
        }

        if (isAllSame) {
            if (unit == 1) {
                bc++;
            } else {
                wc++;
            }
        } else {
            int half = N / 2;
            find(x, y, half);
            find(x + half, y, half);
            find(x, y + half, half);
            find(x + half, y + half, half);
        }
    }
}
