package Silver3;

import java.io.*;

public class Practice11726 {
    static Long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int getNum = Integer.parseInt(br.readLine());
        // n은 1~1000, 출력은 10007의 나머지
        // 빈공간이 없게 채우기 때문에 두 타일이 엇갈리게 매칭될 수 없음
        // 그러면 반복되는 모양으로 배열 가능함
        // 1000같이 큰 값이 들어오면, 에러를 발생시키기 때문에 중간중간 나눠야할 필요 있음
        dp = new Long[1001];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 3L; // =l, l=
        dp[4] = 5L;  // == =ll ll=
        long result = dynamic(getNum);
        bw.write(result + "");
        bw.close();
        br.close();

    }

    static long dynamic(int n) {
        if (dp[n] == null) {
            dp[n] = (dynamic(n - 2) + dynamic(n - 1))%10007;
        }
        return dp[n];
    }
}
