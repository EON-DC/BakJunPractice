package 입출력과_사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice10430 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        System.out.println((a + b)%c);
        System.out.println((a%c + b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c)*(b%c)%c);

    }

    public static void main(String[] args) throws IOException {
        new Practice10430().solution();
    }
}

