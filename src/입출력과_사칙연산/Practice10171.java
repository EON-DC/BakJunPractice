package 입출력과_사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Practice10171 {

    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\\n" +
                " )  ( ')\n"
                +"(  /  )\n"
                +" \\(__)|\n"
        );
        bw.newLine();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Practice10171().solution();
    }
}

