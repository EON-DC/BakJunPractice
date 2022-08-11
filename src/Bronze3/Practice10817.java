package Bronze3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice10817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int temp = Integer.parseInt(token.nextToken());
            list.add(temp);
        }

        Collections.sort(list);
        bw.write(list.get(1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

}