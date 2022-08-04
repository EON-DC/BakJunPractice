package 조건문;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice4 {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if (x * y > 0) {
            if (x > 0) {
                System.out.println(1);
            } else {
                System.out.println(3);
            }
        } else {
            if (x > 0) {
                System.out.println(4);
            } else {
                System.out.println(2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Practice4().solution();
    }
}

