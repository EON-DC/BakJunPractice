package 입출력과_사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class Practice2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int min = (a < b) ? a : b;

        // 최대공약수 the greatest common denominator(GCD)
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        // 최소공배수 the least common multiple (LCM)
        int lcm = a * b / gcd;

        bw.write(gcd + "\n" + lcm);

        bw.flush();
        bw.close();
        br.close();

    }

}
