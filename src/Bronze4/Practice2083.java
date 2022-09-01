package Bronze4;

import java.io.*;

public class Practice2083 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();

        while (true) {
            String line = br.readLine();
            String[] data = line.split(" ");
            if (line.equals("# 0 0")) {
                break;
            }
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            int bwt = Integer.parseInt(data[2]);
            builder.append(name);
            if(age>17 || bwt >= 80){
                builder.append(" Senior");
            } else builder.append(" Junior");
            builder.append("\n");
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();

    }


}
