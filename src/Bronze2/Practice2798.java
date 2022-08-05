package Bronze2;

import java.io.*;
import java.util.StringTokenizer;

public class Practice2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(token.nextToken());
        int[] arr = new int[testCase];
        int M = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        // 브루트포스 알고리즘
        // 만약 세 인자의 합이 M과 같으면 result 로 반환
        // temp = a + b + c

        int result = blackjack(arr, M);
        bw.write(result + "");


        bw.flush();
        bw.close();
        br.close();

    }

    public static int blackjack(int[] arr, int M) {
        int temp, result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    temp = arr[i] + arr[j] + arr[k];
                    if (temp == M) {
                        return temp;
                    }
                    if (temp < M && result < temp) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}

