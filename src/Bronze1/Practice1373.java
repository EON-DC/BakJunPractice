package Bronze1;

import java.io.*;

public class Practice1373 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        // 나머지에 따라 시작지점을 나누고, 3개씩 글자열을 나눈다.
        // 나눈 글자열의 자리수에 따라 builder 에 집어넣고
        // 순서에 따라 출력한다.
        StringBuilder builder = new StringBuilder();
        int resi = s.length() % 3;
        String sresi = s.substring(0, resi);
        if (resi != 0) {
            s= s.substring(resi);
            switch (resi) {
                case 1:
                    builder.append(sresi.charAt(0) - '0');
                    break;
                case 2:
                    int temp = (sresi.charAt(0) - '0') * 2 + (sresi.charAt(1) - '0');
                    builder.append(temp);
                    break;
            }
        }
        for (int i = 0; i <s.length(); i +=3) {
            int temp =    (s.charAt(i) - '0') * 4
                    + (s.charAt(i + 1) - '0') * 2
                    + (s.charAt(i + 2) - '0');
            builder.append(temp);
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}