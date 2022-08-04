package 조건문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2884 {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] x = new int[3];
        x[0] = Integer.parseInt(token.nextToken());
        x[1] = Integer.parseInt(token.nextToken());
        x[2] = x[0] * 60 + x[1] - 45;
        if (x[2] < 0) {
            x[2] += 1440;
        }
        System.out.println(x[2]/60 + " " + x[2]%60);
    }

    public static void main(String[] args) throws Exception {
        new Practice2884().solution();
    }
}

