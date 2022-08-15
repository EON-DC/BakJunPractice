package Silver1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int canCarry = Integer.parseInt(token.nextToken());
        int buyBottle = 0;
        while (true) {
            if (binaryOneCounter(N) <= canCarry) {
                break;
            }
            N++;
            buyBottle++;
        }
        int result = buyBottle;
        bw.write(result + "");
        bw.close();
        br.close();
    }

    public static int binaryOneCounter(int N) {
        String binaryN = Integer.toBinaryString(N);
        int count = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
