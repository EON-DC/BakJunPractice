package 입출력과_사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1008 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        double[] arr = new double[2];
        arr[0] = Integer.parseInt(token.nextToken());
        arr[1] = Integer.parseInt(token.nextToken());
        System.out.println(arr[0] / arr[1]);
        br.close();

    }

    public static void main(String[] args) throws Exception {
        new Practice1008().solution();
    }
}

