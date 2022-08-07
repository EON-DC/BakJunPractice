package Silver4;

import java.io.*;

public class Practice2839 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        // 그리디 알고리즘
        // input에 들어온 값을 먼저 5로 나눠 몫을 봉투(result)에 더하고
        // 나머지를 3으로 나눴을 때, 나머지가 없으면, 몫을 봉투에 더함
        // 나머지가 있으면 -1을 출력하고 프로그램을 종료한다 -> failed
        // 11이 들어온 경우, 5 한봉투, 3키로 두봉투 갖고갈 수 있음
        // 정확하게 나눠갈 수 없는 경우
        int result = input / 5;
        int remainder = input % 5;
        // remainder 가 1 일 경우
        // 5를 한번 덜 가져갔을 때 필요 설탕 완성 가능
        // remainder 가 3 일때 무상관
        // remainder 2 일때는 5를 2번 못가져가면 완성 가능
        // remainder 4 일때는 한번 못가져가면 완성가능


        if (input == 4 || input == 7) {
            bw.write("-1");
        } else {
            switch (remainder) {
                case 0:
                    bw.write(result + "");
                    break;
                case 1:
                case 3:
                    result++;
                    bw.write(result + "");
                    break;
                case 2:
                case 4:
                    result++;
                    result++;
                    bw.write(result + "");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
