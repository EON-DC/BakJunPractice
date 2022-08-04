package 입출력과_사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Practice10718 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(a + b);
//    }


    // 공백으로 입력 받을 경우

    // 한줄로 입력 받을 경우


    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("강한친구 대한육군\n강한친구 대한육군");
        bw.newLine();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Practice10718().solution();
    }
}

