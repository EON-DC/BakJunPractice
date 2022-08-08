package Bronze1;

import java.io.*;
public class Practice2748 {
    static long[] fiboArr = new long[91];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        for (int i = 0; i < 91; i++) {
            fiboArr[i] = -1;
        }

        fiboArr[0] = 0L;
        fiboArr[1] = 1L;
        fiboArr[2] = 1L;
        fiboArr[3] = 2L;

        int getnum = Integer.parseInt(br.readLine());

        bw.write(fiboCal(getnum) + "");
        bw.close();
        br.close();
    }

    public static long fiboCal(int n) {
        if (fiboArr[n] == -1) {
            fiboArr[n] = fiboCal(n - 1) + fiboCal(n - 2);
        }
        return fiboArr[n];
    }
}
