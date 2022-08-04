package 입출력과_사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2588 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int b100 = b / 100 * 100;
        int b10 = b % 100 - b % 10;
        int b1 = b % 10;
        System.out.println(a * b1);
        System.out.println(a * b10 / 10);
        System.out.println(a * b100 / 100);
        System.out.println(a * b);
    }

    public static void main(String[] args) throws IOException {
        new Practice2588().solution();
    }
}

