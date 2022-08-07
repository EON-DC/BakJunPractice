package Bronze2;

import java.io.*;

public class Practice2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int input = Integer.parseInt(br.readLine());
        // 우리가 찾으려는 수의 분해합이 input이 되야함.
        for (int i = 1; i <= input; i++) {
            if (verify(i, input)) {
                System.out.println(i);
                return;
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean verify(int n, int input) {
        String sn = String.valueOf(n);
        int num = n;
        int sum = 0;
        for (int i = 0; i < sn.length(); i++) {
            int temp = n % 10;
            n /= 10;
            sum += temp;
        }
        if ((num + sum) == input) {
            return true;
        } else {
            return false;
        }
    }
}
