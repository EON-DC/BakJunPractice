package Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1780 {


    static int map[][];
    static int N;
    static int minus, zero, one;

    static void cut(int x, int y, int biggerSize) {
        int size = biggerSize / 3;
        int type = map[x][y];
        boolean isAllSame = true;
        if (biggerSize > 1) {
            Outer:
            for (int i = x; i < x+biggerSize; i++) {
                for (int j = y; j < y+biggerSize; j++) {
                    if (map[i][j] != type) {
                        isAllSame = false;
                        break Outer;
                    }
                }
            }
        }
        if (!isAllSame) {
            for (int i = x; i < x + biggerSize; i += size) {
                for (int j = y; j < y + biggerSize; j += size) {
                    cut(i, j, size);
                }
            }
            return;
        }
        if (isAllSame) {
            switch (type) {
                case -1:
                    minus++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
            }
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        minus = 0;
        zero = 0;
        one = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        cut(0, 0, N);
        bw.write(minus+"\n"+zero+"\n"+one+"\n");
        bw.flush();
        bw.close();
        br.close();
    }


}
