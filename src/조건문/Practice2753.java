package 조건문;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2753 {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int yr = Integer.parseInt(tokenizer.nextToken());
        if (yr % 4 == 0 && (yr % 100 != 0 || yr % 400 == 0)) {
            System.out.println("1");
        }else
            System.out.println("0");
        }


    public static void main(String[] args) throws Exception {
        new Practice2753().solution();
    }
}

