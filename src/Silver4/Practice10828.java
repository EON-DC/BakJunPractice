package Silver4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int inputLine = Integer.parseInt(br.readLine());
        StringTokenizer token;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputLine; i++) {
            token = new StringTokenizer(br.readLine());
            String command = token.nextToken();
            switch (command) {
                case "push":
                    int input = Integer.parseInt(token.nextToken());
                    stack.add(input);
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        int popped = stack.pop().intValue();
                        bw.write(popped + "\n");
                    } else bw.write("-1\n");
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        int temp = stack.peek();
                        bw.write(temp + "\n");
                    }else  bw.write("-1\n");
                    break;
                case "size":
                    int size = stack.size();
                    bw.write(size + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        bw.write("1\n");
                    } else bw.write("0\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
