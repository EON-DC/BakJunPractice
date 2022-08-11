package Bronze3;

import java.io.*;

public class Practice11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringBuilder builder = new StringBuilder();

        int ll = line.length();
        int cycle = ll / 10;
        int resi = ll % 10;
        for (int i = 0; i < cycle; i++) {
            String substring = line.substring((i * 10), (i + 1) * 10);
            builder.append(substring + "\n");
        }
        String substring = line.substring((cycle * 10), cycle * 10 + resi);
        builder.append(substring);


        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
