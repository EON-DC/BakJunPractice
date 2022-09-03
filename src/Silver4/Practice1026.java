package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice1026 {
    static int[] arrA, arrB;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        arrB = new int[n];
        min = Integer.MAX_VALUE;

        // A에 대해 입력
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(line[i]);
        }

        // B에 대해 입력
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(line[i]);
        }

        // 전략 : A의 오름차순과 B의 내림차순을 서로 곱하게 한다
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) arrA[i] * arrB[n-i-1]);
        }

        System.out.println(sum);
    }

}
