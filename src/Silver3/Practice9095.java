package Silver3;

import java.io.*;

public class Practice9095 {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int testCycle = Integer.parseInt(br.readLine());

        // dp[n] 각 숫자를 입력했을 때 나눌수 있는 경우의 수를 저장하고 그때그때 갖다 쓴다.

        dp = new Integer[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 0; i < testCycle; i++) {
            int getNum = Integer.parseInt(br.readLine());
            bw.write(dynamic(getNum)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int dynamic(int n) {

        if (dp[n] == null) {
            dp[n] = dynamic(n-1) + dynamic(n-2) + dynamic(n-3);
        }

        return dp[n];
    }
}
