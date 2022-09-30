package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11727 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;


        System.out.println(find(N));

    }

    public static int find(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (find(n-1) + 2 * find(n-2)) % 10007;
        return dp[n];
    }
}
/**
 * dp[3] = 5
 */
