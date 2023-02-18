package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Practice1034 {
    static String src = "14 3\n" +
            "001\n" +
            "101\n" +
            "001\n" +
            "000\n" +
            "111\n" +
            "001\n" +
            "101\n" +
            "111\n" +
            "110\n" +
            "000\n" +
            "111\n" +
            "010\n" +
            "110\n" +
            "001\n" +
            "6";

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static String[] map;
    static int[] offCount;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));


        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new String[N];
        offCount = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            char[] row = map[i].toCharArray();
            int tmp = 0;
            for (int j = 0; j < M; j++) {
                if (row[j] == '0') {
                    tmp++;
                }
            }
            offCount[i] = tmp;
        }
        K = Integer.parseInt(br.readLine());

        int[] respondingRowCount = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                if (map[i].equals(map[j])) {
                    tmp++;
                }
            }
            respondingRowCount[i] = tmp;
        }
        for (int i = 0; i < N; i++) {
            if (offCount[i] <= K && (K - offCount[i]) % 2 == 0) {
                result = Math.max(result, respondingRowCount[i]);
            }
        }

        System.out.println(result);
    }
}
