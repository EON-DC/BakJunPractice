package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1025 {

    static String src = "2 3\n" +
            "123\n" +
            "456";
    static int N, M;
    static int result = -1;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //br = new BufferedReader(new StringReader(src));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int x = -N; x < N; x++) {
                    for (int y = -M; y < M; y++) {
                        if (x == 0 && y == 0) continue;
                        int a = i, b = j;
                        int now = 0;
                        while (a >= 0 && a < N && b >= 0 && b < M) {
                            now *= 10;
                            now += map[a][b];
                            if (isSquare(now)) result = Math.max(result, now);
                            a += x;
                            b += y;
                        }
                        if (isSquare(now)) result = Math.max(result, now);

                    }

                }
            }
        }

        System.out.println(result);


    }

    public static boolean isSquare(int num) {
        int temp = (int) (Math.sqrt(num) + 0.5);
        if (temp * temp == num) {
            return true;
        } else {
            return false;
        }
    }
}

