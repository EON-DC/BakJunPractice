package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1010_DP {

    static int[][] dp = new int[30][30];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int result = combination(M, N);
            bw.write(result + "\n");
        }


        bw.flush();
        bw.close();
        br.close();


    }

    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        return dp[n][r];
    }
}