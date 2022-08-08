package Silver3;
import java.io.*;
public class Practice1463 {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int getNum = Integer.parseInt(br.readLine());
        dp = new Integer[getNum + 1];
        dp[0] = 0;
        dp[1] = 0;
        bw.write(cal(getNum) + "");
        bw.close();
        br.close();
    }

    static int cal(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(cal(n - 1), Math.min(cal(n / 3), cal(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(cal(n / 3), cal(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(cal(n / 2), cal(n - 1)) + 1;
            } else {
                dp[n] = cal(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
