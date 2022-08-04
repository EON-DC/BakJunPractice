package Silver4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int num = Integer.parseInt(br.readLine());
        if (num == 1) {
            bw.write("1");
        }

        // 큐 구조
        // pop을 하고
        // 다시 pop한 것을 push
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            int polled = queue.poll();
            queue.add(polled);
            if (queue.size() == 1) {
                bw.write(queue.peek()+"");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
