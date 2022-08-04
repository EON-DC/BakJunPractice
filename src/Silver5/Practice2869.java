package Silver5;

import java.io.*;
import java.util.StringTokenizer;

public class Practice2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer token = new StringTokenizer(br.readLine());

        long A = Long.parseLong(token.nextToken());
        long B = Long.parseLong(token.nextToken());
        long V = Long.parseLong(token.nextToken());


        long day = (V - A) / (A - B) + 1L;

        bw.write(day+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
