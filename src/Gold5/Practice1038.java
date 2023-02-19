package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice1038 {
    static String src = "18";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(br.readLine());
        if (N >= (int) Math.pow(2, 10) -1) {
            System.out.println(-1);
            return;
        }
        init();
        Collections.sort(list);
        System.out.println(list.get(N));
//        for (int i = 0; i < 1023; i++) {
//            System.out.println(list.get(i));
//        }
    }

    public static void init() {
        for (int i = 0; i < 1024; i++) {
            String temp = Integer.toBinaryString(i);
            addList(temp);
        }
    }

    public static void addList(String temp) {
        StringBuilder sb = new StringBuilder();
        char[] temps = temp.toCharArray();
        int offset = 10 - temps.length;
        char[] nums = new char[10];
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] == '1') {
                nums[i + offset] = '1';
            }
        }
        for (int i = 0; i < 10; i++) {
            if (nums[i] == '1') {
                sb.append(9 - i);
            }
        }
        if (sb.length() != 0) {
            list.add(Long.parseLong(sb.toString()));
        }
    }


}
