import java.io.*;
import java.util.StringTokenizer;

class baseMain {
    /**
     *
     */
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());

        result = 0;
        bw.write(result + "");

        bw.close();
        br.close();
    }

}