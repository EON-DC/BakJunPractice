package 입출력과_사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class Practice10998 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[2];
        arr[0] = Integer.parseInt(token.nextToken());
        arr[1] = Integer.parseInt(token.nextToken());
        System.out.println(arr[0] * arr[1]);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Practice10998().solution();
    }
}

