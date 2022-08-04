package 조건문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice1330 {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        if (a > b) {
            System.out.println(">");

        } else if (a < b) {
            System.out.println("<");
        } else
            System.out.println("==");

    }

    public static void main(String[] args) throws Exception {
        new Practice1330().solution();
    }
}

