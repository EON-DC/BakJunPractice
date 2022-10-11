package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice1932 {


    static int n;
    static int[][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
            if (i == n - 1) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = map[i][j];
                }
            }
        }
        System.out.println(find(0, 0));
    }

    public static int find(int depth, int idx) {
        if (depth == n-1) {
            return dp[depth][idx];
        }
        if (dp[depth][idx] == -1) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + map[depth][idx];
        }
        return dp[depth][idx];
    }
}
