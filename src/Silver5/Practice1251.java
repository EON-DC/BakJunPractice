package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Practice1251 {


    /**
     * 1251번 단어나누기
     * 3이상, 50이하의 길이
     * 어떻게 나누느냐에 따라 가장 사전순 나오는 단어가 갈림.
     * 경우의 수 :  글자수 -1 에서 두개 조합
     */


    static String word;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    static void divide(String s, int[] arr, int n, int r, int index, int target) {
        if (r == 0) {
            builder = new StringBuilder();
            builder.append(reverse(s.substring(0, arr[0])));
            builder.append(reverse(s.substring(arr[0], arr[1])));
            builder.append(reverse(s.substring(arr[1])));
//            System.out.println("Arrays.toString(picked) = " + Arrays.toString(arr));
//            System.out.println("s.substring(0, arr[0]) = " + reverse(s.substring(0, arr[0])));
//            System.out.println("s.substring(arr[0], arr[1])) = " + s.substring(arr[0], arr[1]));
//            System.out.println("s.substring(arr[1]) = " + s.substring(arr[1]));
            list.add(builder.toString());
            return;
        }
        if (target == n) return;
        arr[index] = target;
        divide(s, arr, n, r - 1, index + 1, target + 1);
        divide(s, arr, n, r, index, target + 1);
    }

    static String reverse(String s) {
        StringBuilder builder2 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder2.append(s.charAt(i));
        }
        return builder2.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        word = br.readLine();
        int[] arr = new int[2];
        divide(word, arr, word.length(), 2, 0, 1);
        Collections.sort(list);
        //System.out.println("list.toString() = " + list.toString());
        String result = list.get(0);
        bw.write(result);
        //System.out.println("result = " + result);

        bw.flush();
        bw.close();
        br.close();
    }
}