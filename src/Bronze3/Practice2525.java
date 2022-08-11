package Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class Practice2525 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();
        int hh = Integer.parseInt(token.nextToken());
        int mm = Integer.parseInt(token.nextToken());
        int makingmm = Integer.parseInt(br.readLine());
        int presentTime = hh * 60 + mm;
        presentTime += makingmm;
        if (presentTime >= 1440) {
            presentTime -= 1440;
        }
        hh = presentTime / 60;
        mm = presentTime % 60;

        builder.append(hh + " ").append(mm);
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}