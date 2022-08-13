package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1010_math {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            long N = Long.parseLong(token.nextToken());
            long M = Long.parseLong(token.nextToken());

            long result = combination(M, N);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int combination(long n, long r) {
        int result = 1;
        if (n != r) {
            for (long i = 0; i < r; i++) {
                result *= (n - i);
                result /= (i + 1);
            }
        }
        return result;
    }
}