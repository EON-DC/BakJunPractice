package Bronze1;

import java.io.*;

public class Practice1356 {


    static int N, front, back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        N = Integer.parseInt(line);
        boolean flag = false;
        for (int i = 0; i < line.length() - 1; i++) {
            front = 1;
            back = 1;
            for (int k = 0; k <= i; k++) {
                int frontEle = line.charAt(k) - 48;
                front *= frontEle;

            }
            for (int j = line.length() - 1; j > i; j--) {
                int backEle = line.charAt(j) - 48;
                back *= backEle;


            }

            if (front == back) {
                flag = true;
                break;
            }
        }
        if (flag) {
            bw.write("YES");
        } else bw.write("NO");
        bw.flush();
        bw.close();
        br.close();
    }

}