package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice11651 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCycle = Integer.parseInt(br.readLine());
        ArrayList<Pointer> pointers = new ArrayList<>();
        StringTokenizer token;
        for (int i = 0; i < testCycle; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            Pointer pointer = new Pointer(x, y);
            pointers.add(pointer);
        }
        Collections.sort(pointers);
        for (int i = 0; i < pointers.size(); i++) {
            bw.write(pointers.get(i).toString() + "\n");
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
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Pointer o) {
            if (this.y == o.y && this.x < o.x) {
                return -1;
            } else
                return this.y - o.y;
        }
    }
}
