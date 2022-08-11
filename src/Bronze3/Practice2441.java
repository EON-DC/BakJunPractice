package Bronze3;

import java.io.*;

public class Practice2441 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = N - i; j < N; j++) {
                builder.append(" ");
            }
            for (int j = i; j < N; j++) {
                builder.append("*");
            }
            builder.append("\n");
        }
        bw.write(builder.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
