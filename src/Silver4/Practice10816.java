package Silver4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Practice10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int input = Integer.parseInt(token.nextToken());
            if (map.containsKey(input)) {
                int data = map.get(input);
                map.put(input, ++data);
            } else {
                map.put(input, 1);
            }
        }
        int testSize = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < testSize; i++) {
            int input = Integer.parseInt(token.nextToken());
            if (map.containsKey(input)) {
                bw.write(map.get(input)+"");
            } else {
                bw.write("0");
            }
            if (i < testSize - 1) {
                bw.write(" ");
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
