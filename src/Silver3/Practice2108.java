package Silver3;

import java.io.*;
import java.util.Arrays;

public class Practice2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int inputLine = Integer.parseInt(br.readLine());

        // 메모리를 아끼기 위해 저장하지 않는다면? 실패시 생각
        // 산술 평균 : 최대 가능한 범위는 4000  * 500,000 이므로, for 받으면서 sum은 int로 받기
        // 중앙값 : 리스트로 입력 받고 sorting , index = n/2 (always odd num)
        // 최빈값 : 입력 받으면서 동시에 counting sorting 예정
        // 범위 : sorting list 의 index 0, length -1 의 차, abs
        // 또는 min, max 연산을 추가해서, 이들의 차 구해도 됨.

        int[] arr = new int[8001]; // (-4000 ~ 4000) cover
        Arrays.fill(arr, (short) 0);
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= inputLine; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            arr[input + 4000]++;
            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }
            // count 배열 : arr
            // if input -4000 -> index = 0
            // if input 0 -> index 4000
            // if input 1 -> index 4001
            // if input 4000  -> index = 8001
        }

        int count = 0;
        int median = Integer.MIN_VALUE;
        int bindoMax = 0; // 최빈도의 개수
        int bindo = 0; // 최빈도의 값
        boolean flag = false; // true 가 되면, 최빈도의 입력이 들어온 상태, 두번째 값을 bindo에 넣게한다.

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) { // count가 된 수들
                if (count < (inputLine + 1) / 2) {
                    count += arr[i]; // 여태 나열된 수들의 개수가 inputline의 절반이 될 때 들어오는 값이
                    median = i - 4000; // 마지막에 들어온 i가 median이 됨
                }

                if (bindoMax < arr[i]) {
                    bindoMax = arr[i];
                    bindo = i - 4000;
                    flag = true;
                } else if (bindoMax == arr[i] && flag == true) {
                    bindo = i - 4000;
                    flag = false;
                }
            }
        }

        bw.write((int) Math.round((double) sum / inputLine) + "");
        bw.write("\n" + median + "\n");
        bw.write(bindo + "\n");
        bw.write((max - min) + "");


        bw.flush();
        bw.close();
        br.close();

    }
}
