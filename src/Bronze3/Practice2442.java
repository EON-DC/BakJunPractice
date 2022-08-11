package Bronze3;

import java.io.*;

public class Practice2442 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder builder = new StringBuilder();
        int cycle = Integer.parseInt(br.readLine());
        for (int i = 0; i < cycle; i++) {
            for (int j = cycle - i; j > 1; j--) {
                builder.append(" ");
            }
            for (int j = 0; j < 1 + 2 * i; j++) {
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