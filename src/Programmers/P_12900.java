package Programmers;

import java.util.*;
public class P_12900 {
    static int[] dp;
    public int solution(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dpM(n);

        return dp[n];
    }
    public int dpM (int depth){
        if(dp[depth] != -1){
            return dp[depth];
        }
        dp[depth] = (dpM(depth-1) + dpM(depth-2))%1000000007;

        return dp[depth];
    }
}