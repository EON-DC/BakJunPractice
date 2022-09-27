package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Practice11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.remove());
                } else {
                    System.out.println(0);
                }
            }
            pq.add(input);
        }
    }
}

