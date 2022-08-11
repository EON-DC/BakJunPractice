package Bronze1;

import java.io.*;

public class Practice1193 {


    // 1193번
    // 등차수열로 n번째 행의 마지막은 n(n+1)/2
    // 홀짝으로 순번이 나뉨


    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        boolean flag = true;
        int line = 0;
        while (flag) {
            line++;
            if ((((line * line) + line) / 2) >= N) {
                if (line % 2 == 0) {
                    N -= (((line * line) - line) / 2);
                    bw.write(N + "/" + (line + 1 - N));
                    break;
                } else {
                    N -= (((line * line) - line) / 2);
                    bw.write((line + 1 - N) + "/" + N);
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
