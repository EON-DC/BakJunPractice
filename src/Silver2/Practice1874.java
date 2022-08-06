package Silver2;

import java.io.*;
import java.util.Stack;

public class Practice1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int inputLine = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();

        int offer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputLine; i++) {
            int target = Integer.parseInt(br.readLine());
            if (offer < target) {
                for (int j = offer+1; j <= target; j++) {
                    stack.push(j);
                    builder.append("+\n");
                }
                offer = target;
            } else if (stack.peek() != target) {
                builder.delete(0, builder.length());
                bw.write("NO");
                bw.flush();
                return;

            }
            stack.pop();
            builder.append("-\n");
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
