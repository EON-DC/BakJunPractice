package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11659 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[] arr = new int[n+1];
            line = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(line[i-1]) + arr[i-1];
            }

            while (m-- > 0) {
                line = br.readLine().split(" ");
                int i = Integer.parseInt(line[0]);
                int j = Integer.parseInt(line[1]);

                System.out.println(arr[j] - arr[i-1]);
            }
        }
    }
