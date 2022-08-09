package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice14501 {

    static int timeSpend[];
    static int price[];
    static int n;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        timeSpend = new int[n];
        price = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            timeSpend[i] = Integer.parseInt(token.nextToken());
            price[i] = Integer.parseInt(token.nextToken());
        }
        go(0, 0);
        System.out.println(ans);
    }

    private static void go(int index, int sum) {
        if (index == n) { //종착
            if (sum > ans) {
                ans = sum;
            }
            return;
        }
        if (index > n) {
            return;
        }
        // 일 했을 때, 안했을 때 각각 실행시키기
        go(index + timeSpend[index], sum + price[index]);
        go(index + 1, sum);
    }

}