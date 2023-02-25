package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Practice1011 {
    static String src = "3\n" +
            "0 3\n" +
            "1 5\n" +
            "45 50";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);

            int result = search(X, Y);
            System.out.println(result);
        }
    }

    public static int search(int X, int Y) {

        int distance = Y - X;
        int max = (int) Math.sqrt(distance);    // 소수점 버림
        int count = 0;

        if (max == Math.sqrt(distance)) {
            count = (2 * max - 1);
        } else if (distance <= max * max + max) {
            count = (2 * max);
        } else {
            count = (2 * max + 1);
        }
        return count;
    }
}
