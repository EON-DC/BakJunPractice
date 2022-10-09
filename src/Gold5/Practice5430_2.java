package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Practice5430_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // test cycle
        Outer:
        while (tc-- > 0) {
            char[] orders = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());
            String sArr = br.readLine();
            sArr = sArr.substring(1, sArr.length() - 1);
            StringTokenizer token = new StringTokenizer(sArr, ",");
            Deque<Integer> deque = new ArrayDeque<>();
            if (size != 0) {
                while (token.hasMoreTokens()) {
                    deque.add(Integer.parseInt(token.nextToken()));
                }
            }
            boolean direction = true;
            for (int i = 0; i < orders.length; i++) {
                char order = orders[i];
                switch (order) {
                    case 'R':
                        direction = !direction;
                        break;
                    case 'D':
                        if (deque.size() <1 ) {
                            System.out.println("error");
                            continue Outer;
                        }
                        if (direction) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }

                }
            }
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            if (deque.isEmpty()) {
                flag = false;
            }
            sb.append("[");
            if (direction) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst() + ",");

                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast() + ",");
                }
            }
            if (flag) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
