package Silver3;

import java.io.*;

public class Practice1003 {
    static Integer[][] list = new Integer[41][2];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        //fibonacci(0), (1) 이 각각 몇번 호출되는가.

        list[0][0] = 1;
        list[0][1] = 0;
        list[1][0] = 0;
        list[1][1] = 1;

        int testCycle = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCycle; i++) {
            int getNum = Integer.parseInt(br.readLine());
            fiboOne(getNum);
            bw.write(list[getNum][0] + " " + list[getNum][1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static Integer[] fiboOne(int n) {

        if (list[n][0] == null || list[n][1] == null) {
            list[n][0] = fiboOne(n - 1)[0] + fiboOne(n - 2)[0];
            list[n][1] = fiboOne(n - 1)[1] + fiboOne(n - 2)[1];
        }

        return list[n];
    }
}
