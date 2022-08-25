package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice1551 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        String[] arr = br.readLine().split(",");
        ArrayList<Integer> list = new ArrayList<>();

        int index = 0;
        for (String s : arr) {
            list.add(Integer.parseInt(s));
        }
        while (K-- > 0) {
            transform(list);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            bw.write(list.get(i) + ",");
        }
        bw.write(list.get(list.size() - 1) + "");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void transform(ArrayList<Integer> list) {
        int length = list.size();
        int[] bArr = new int[list.size() - 1];
        for (int i = 0; i < length - 1; i++) {
            bArr[i] = list.get(i + 1) - list.get(i);
        }
        list.clear();
        for (int i : bArr) {
            list.add(i);
        }
    }

}

