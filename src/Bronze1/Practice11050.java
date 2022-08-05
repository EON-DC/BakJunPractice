package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        // 이항정리 식 :  n! / k!(n-k)!

        int result = 1, temp = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 1; i <= k; i++) {
            temp *= i;
        }
        for (int i = 1; i <= n - k; i++) {
            temp *= i;
        }
        result = result / temp;

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
