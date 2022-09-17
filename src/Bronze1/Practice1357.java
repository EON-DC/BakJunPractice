package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer token = new StringTokenizer(br.readLine());
        String X = token.nextToken();
        String Y = token.nextToken();

        int answer = Rev(Rev(X) + Rev(Y));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Rev(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(s.length() - i - 1));
        }
        return Integer.parseInt(builder.toString());

    }

    public static int Rev(int i) {
        String s = String.valueOf(i);
        return Rev(s);
    }
}