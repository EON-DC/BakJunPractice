package Silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice11047 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tempCoin = Integer.parseInt(br.readLine());
            if (K >= tempCoin) {
                // dummy coin 제외
                coins.add(tempCoin);
            }
        }

        // 동전이 배수로 이루어져있으므로, 그리디 적용
        int coinCounter = 0;
        while (true) {
            int lastBigCoin = 0;
            for (int i = coins.size() - 1; i >= 0; i--) {
                if (K - coins.get(i) >= 0) {
                    lastBigCoin = coins.get(i);
                    break;
                }
            }
            K -= lastBigCoin;
            coinCounter++;
            if (K > 0) {
                continue;
            } else if (K < 0) {
                coinCounter = -1;
                break;
            } else {
                break;
            }
        }
        bw.write(coinCounter + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


