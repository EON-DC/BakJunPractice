package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1699 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        System.out.println(dynamic(n));
    }

    public static int dynamic(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j * j <= i; j++) {
                if (dp[i] > dp[i - (j * j)] + 1) {
                    dp[i] = dp[i - (j * j)] + 1;
                }
            }
        }
        return dp[n];
    }
}
