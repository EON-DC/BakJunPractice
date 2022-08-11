package Silver5;

import java.io.*;

public class Practice1094 {

    // 1094번 문제
    // 입력 파라 : 64보다 작거나 같은 자연수
    // 비트로 나타냈을 때 1 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        String line = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (1 == line.charAt(i) - 48) {
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}