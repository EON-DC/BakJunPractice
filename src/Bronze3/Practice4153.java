package Bronze3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(token.nextToken());
            arr[1] = Integer.parseInt(token.nextToken());
            arr[2] = Integer.parseInt(token.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }
            Arrays.sort(arr);
            if ((arr[2] * arr[2]) == (((arr[1] * arr[1]) + (arr[0] * arr[0])))) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
