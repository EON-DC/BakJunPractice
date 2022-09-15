package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice6064 {
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            int y = Integer.parseInt(line[3]);

            int lcm = getLcm(M, N);
            int calYr = x;
            if (y == N) {
                while (calYr % N != 0) {
                    calYr += M;
                    if (calYr > lcm) {
                        calYr = -1;
                        break;
                    }
                }
            } else {
                while (calYr % N != y) {
                    calYr += M;
                    if (calYr > lcm) {
                        calYr = -1;
                        break;
                    }
                }
            }
            System.out.println(calYr);
        }

    }

    public static int getLcm(int M, int N) {
        int cM = M;
        int cN = N;
        while (N != 0) {
            int r = M % N;
            M = N;
            N = r;
        }
        int gcd = M;
        return cM * cN / gcd;
    }

}