package Bronze1;

import java.io.*;

public class Practice1526 {


    /**
     * 1526번 가장 큰 금민수 찾기
     * N이 주어지면, top-bottom 방식으로 브룻포스 검증
     * charToArray, '4' '7' 뺐을 때 모두 0이어야함
     * 테스트에 통과하면, 그대로 출력
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = num; i > 3; i--) {
            char[] chars = String.valueOf(i).toCharArray();
            boolean flag = false;
            for (int j = 0; j < chars.length; j++) {
                if ((chars[j] - '4') == 0 || (chars[j] - '7') == 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            } else {
                bw.write(i + "");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}