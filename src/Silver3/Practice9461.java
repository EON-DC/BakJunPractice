package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        while (tc-- > 0) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(find(input));
        }

    }

    public static long find(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = find(n - 2) + find(n - 3);
        return dp[n];
    }
}

