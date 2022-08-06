package Silver5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int inputLine = Integer.parseInt(br.readLine());
        StringTokenizer token;
        Pointer[] pointers = new Pointer[inputLine];
        for (int i = 0; i < inputLine; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            pointers[i] = new Pointer(x, y);
        }

        Arrays.sort(pointers, Pointer::compareTo);

        for (int i = 0; i < inputLine; i++) {
            bw.write(pointers[i].x + " " + pointers[i].y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static class Pointer implements Comparable<Pointer> {

        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pointer o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                if (this.y > o.y) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }

    }
}
