package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Practice1927 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder builder = new StringBuilder();
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                pq.add(input);
            } else if (!pq.isEmpty()) {
                builder.append(pq.poll() + "\n");
            } else {
                builder.append("0\n");
            }
        }
        System.out.println(builder.toString());
    }
}
