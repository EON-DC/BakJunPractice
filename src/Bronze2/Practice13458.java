package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice13458 {
    static String src = "5\n" +
            "1000000 1000000 1000000 1000000 1000000\n" +
            "5 7";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, B, C;
    static int[] arr;

    static long result = 0;


    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(br.readLine());
        String[] arrString = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        String[] bAndc = br.readLine().split(" ");
        B = Integer.parseInt(bAndc[0]);
        C = Integer.parseInt(bAndc[1]);

        for (int i = 0; i < N; i++) {
            int testerCount = arr[i];
            testerCount -= B;
            result += 1;
            while (testerCount > 0) {
                result++;
                testerCount -= C;
            }
        }
        System.out.println(result);

    }
}
