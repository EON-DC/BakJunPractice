package 입출력과_사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice18108 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int yr = Integer.parseInt(tokenizer.nextToken());
        System.out.println(yr-543);
    }

    public static void main(String[] args) throws IOException {
        new Practice18108().solution();
    }
}

