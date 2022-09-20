package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Practice5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Outer:
        while (testCase-- > 0) {
            String orders = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] S_line = line.substring(1, line.length() - 1).split(",");
            Deque<Integer> deque = new ArrayDeque<>();

            if (arrSize != 0) {
                for (int i = 0; i < S_line.length; i++) {
                    deque.add(Integer.parseInt(S_line[i]));
                }
            }

            boolean direction = true;
            String answer = "error";

            for (char order : orders.toCharArray()) {
                switch (order) {
                    case 'D':
                        if (deque.size() < 1) {
                            System.out.println(answer);
                            continue Outer;
                        }
                        if (direction) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                        break;
                    case 'R':
                        direction = !direction;
                }
            }

            StringBuilder builder = new StringBuilder();
            if (direction) {
                while (!deque.isEmpty()) {
                    builder.append(deque.removeFirst() + ",");
                }
            }else{
                while (!deque.isEmpty()) {
                    builder.append(deque.removeLast() + ",");
                }
            }
            if (builder.length() != 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            answer = "[" + builder.toString() + "]";
            System.out.println(answer);
        }
    }
}

