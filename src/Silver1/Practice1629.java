package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        long c = Long.parseLong(line[2]);

        long result = pow(a, b, c);

        System.out.println(result);
    }

    public static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long temp = pow(a, b / 2, c);

        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return (temp * temp % c);
    }
}