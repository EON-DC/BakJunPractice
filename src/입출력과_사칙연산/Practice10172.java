package 입출력과_사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Practice10172 {

    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("|\\_/|\n"
                +"|q p|   /}\n"
                +"( 0 )\"\"\"\\\n"
                +"|\"^\"`    |\n"
                +"||_/=\\\\__|\n"
        );
        bw.newLine();
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        new Practice10172().solution();
    }
}

