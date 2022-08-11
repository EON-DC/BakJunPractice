package Silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Practice1764 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int nh = Integer.parseInt(token.nextToken()); // no hear
        int nw = Integer.parseInt(token.nextToken()); // no watch
        HashSet<String> nhSet = new HashSet<>();

        for (int i = 0; i < nh; i++) {
            nhSet.add(br.readLine());
        }

        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < nw; i++) {
            String gottenName = br.readLine();
            if (nhSet.contains(gottenName)) {
                resultList.add(gottenName);
            }
        }
        Collections.sort(resultList);
        bw.write(resultList.size() + "\n");
        for (String s : resultList) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
