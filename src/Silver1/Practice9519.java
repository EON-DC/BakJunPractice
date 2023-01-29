package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice9519 {

    static List<String> list = new ArrayList<>();
    static Map<String, Integer> store = new HashMap<>();
    static int repeatLength = 0;

    public static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int N = word.length();
        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        list.add(word);

        while (X > 0) {
            head.setLength(0);
            tail.setLength(0);

            if (N % 2 == 0) {// 짝수,  a b c d e f <- a f b e c d
                for (int i = N - 1; i >= 0; i -= 2) {
                    tail.append(word.charAt(i));
                }
                for (int i = 0; i < N; i += 2) {
                    head.append(word.charAt(i));
                }
            } else { //  홀수,  a b c d e f g <- a g b f c e d
                for (int i = N - 2; i >= 0; i -= 2) {
                    tail.append(word.charAt(i));
                }
                for (int i = 0; i < N; i += 2) {
                    head.append(word.charAt(i));
                }
            }
            word = head.append(tail).toString();
            list.add(word);
            if (store.get(word) == null) {
                store.put(word, repeatLength++);
            } else { // 반복 찾은 경우
                break;
            }
            X--;
        }
        if (X > 0) { // 반복을 발견한 경우, while을 종료하고 x가 양수인 상태로 나옴
            X = X % repeatLength;
            System.out.println(list.get(X));
        } else {
            System.out.println(word);
        }

    }
}

