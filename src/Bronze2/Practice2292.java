package Bronze2;

import java.io.*;

public class Practice2292 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

    int num = Integer.parseInt(br.readLine());
    int honeyClass = 1;
    boolean flag = true;
    if (num == 1) {
        bw.write(1+"");
        flag = false;
    }
    while (flag) {
        if (num <= countLastHoneycomb(honeyClass)) {
            bw.write(1+honeyClass+"");
            flag = false;
        } else {
            honeyClass++;
        }
    }
    bw.flush();
    br.close();
    bw.close();
}

    public static int countLastHoneycomb(int honeyClass) {
        // 최외곽 껍데기는 6*honeyclass
        if (honeyClass == 0) {
            return 1;
        }
        if (honeyClass == 1) {
            return 7;
        }
        int outCount = honeyClass * 6;
        return countLastHoneycomb(honeyClass - 1) + outCount;

    }
}
