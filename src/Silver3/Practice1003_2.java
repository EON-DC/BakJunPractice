package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice1003_2 {

    /**
     * 1003번 fibonacci (0) 과 (1)이 각각 몇 번씩 호출되는가에 대한 문제
     * dp[41][2] 로 배열 구성
     * 각각 피보나치를 몇번 호출하는지 메모리얼 한다.
     * 프로그램 시작하고 바로 41까지의 연산을 시행.
     *   * 피보나치 (0)이 호출될 경우, 정적변수에 증가 처리
     * 0~40까지에 대해 입력이 들어올 경우에 대해 배열값 반환
     *
     */

    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int unit = Integer.parseInt(br.readLine());
            System.out.println(dp[unit][0] + " " + dp[unit][1]);
        }

    }

    public static void init() {
        for (int i = 0; i < 41; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 0; i < 41; i++) {
            fibo(i);
        }
    }

    public static int[] fibo(int n) {
        if (dp[n][0] == -1 || dp[n][1] == -1) {
            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }
        return dp[n];
    }
}