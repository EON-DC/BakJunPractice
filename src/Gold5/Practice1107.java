package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Practice1107 {


    static boolean[] unable;
    static int target;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if (M == 0) {
            System.out.println(Math.min(abs(target - 100),String.valueOf(target).length()));
            return;
        } else {
            StringTokenizer token = new StringTokenizer(br.readLine());
            unable = new boolean[10];
            for (int i = 0; i < M; i++) {
                int unalbeButton = Integer.parseInt(token.nextToken());
                unable[unalbeButton] = true;
            }
            int finalResult = abs(target - 100);
            // i 0~ 999999까지 돌아보면서, 가능하면 그때의 approach 단계를 비교한다.
            for (int i = 0; i <= 999999; i++) {
                String tester = String.valueOf(i);
                int length = tester.length();
                boolean isUnable = false;
                for (int j = 0; j < length; j++) {
                    if (unable[tester.charAt(j) - '0']) { // 불가능한 숫자인지 확인
                        isUnable = true;
                        break;
                    }
                }
                if (!isUnable) {
                    int buttonApproach = abs(target - i) + length;
                    finalResult = Math.min(buttonApproach, finalResult);
                }
            }
            System.out.println(finalResult);
        }
    }
}