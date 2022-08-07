package Silver4;

import java.io.*;
import java.util.Stack;

public class Practice10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int testCycle = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < testCycle; i++) {
            long K = Long.parseLong(br.readLine());
            if (K != 0L) {
                stack.add(K);
            } else if (K == 0L) {
                stack.pop();
            }
        }
        Long sum = 0L;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
