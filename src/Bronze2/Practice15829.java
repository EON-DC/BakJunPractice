package Bronze2;

import java.io.*;
import java.math.BigInteger;

public class Practice15829 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        // 다음에 들어올 string을 charToArray,
        // 소문자 a는 97부터 시작한다.
        // a는 1로 계산하니깐. character array를 long으로 변환하면서
        // 각 자리수에 따라 31 제곱을 더한다
        // 더한 값을 제출한다. === > failed
        // why? pow(31, 50) 대략 25자리, long은 18자리까지 커버
        // 담을 수 없는 크기이므로, BigInteger 를 사용하는 전략

        String str = br.readLine();
        char[] chars = str.toCharArray();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < chars.length; i++) {
            //long temp = ((long)chars[i]-96L) * (long)Math.pow(31, i);
            //sum += temp;
            BigInteger temp = BigInteger.valueOf(chars[i] - 96);
            BigInteger pow = BigInteger.ONE;
            for (int j = 0; j < i; j++) {
                pow = pow.multiply(BigInteger.valueOf(31));
            }
            temp = temp.multiply(pow);
            sum = sum.add(temp);
        }
        sum = sum.remainder(BigInteger.valueOf(1234567891));
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
