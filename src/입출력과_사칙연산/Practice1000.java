package 입출력과_사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice1000 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(a + b);
//    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println("a + b = " + (a + b));
    }

    public static void main(String[] args) throws Exception {
        new Practice1000().solution();
    }
}

