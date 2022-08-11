package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1145 {

    // 1145번
    // 브루트포스 알고리즘
    // n을 계속 증가시켜 차례로 나눴을 때, 3개 이상의 수에서 나눠질 경우 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] nums = new int[5];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(token.nextToken());
            min = Math.min(nums[i], min);
        }
        int baesu = min;
        boolean flag = true;
        while (flag) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if ((baesu % nums[i]) == 0) {
                    count++;
                    if (count == 3) {
                        bw.write(baesu + "");
                        flag = false;
                        break;
                    }
                }
            }
            baesu++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
