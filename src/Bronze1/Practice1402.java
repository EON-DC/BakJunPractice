package Bronze1;

import java.io.*;

public class Practice1402 {
    static int tc; // test case

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            bw.write("yes\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
