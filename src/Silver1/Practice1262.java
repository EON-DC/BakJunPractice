package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Practice1262 {
    static String src = "27 0 0 53 53";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int size;
    static int r1, r2, c1, c2;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new StringReader(src));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        size = 2 * N - 1;
        r1 = Integer.parseInt(line[1]);
        c1 = Integer.parseInt(line[2]);
        r2 = Integer.parseInt(line[3]);
        c2 = Integer.parseInt(line[4]);

        // map 을 그리고, get(row, col)을 이용해 StringBuilder에 누적시키도록 한다.
        // r1, c1 값을 offset으로 생각
        StringBuilder sb = new StringBuilder();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sb.append(get(i, j));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static char get(int row, int col) {
        int mapRow = row % size;
        int mapCol = col % size;
        int mapMid = N - 1;
        int distance = Math.abs(mapMid - mapRow) + Math.abs(mapMid - mapCol);
        int range = N - 1;
        if (distance > range) {
            return '.';
        }
        if (distance >= 26) {
            distance %= 26;
        }
        return (char) ('a' + distance);
    }

}

