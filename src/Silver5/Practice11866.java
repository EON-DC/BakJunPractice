package Silver5;

import java.io.*;
import java.util.*;

public class Practice11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        // 요세푸스 문제
        // 원형 n명, k번째, index 가 초기화됨.
        // (index+k)
        // queue 구조로, poll-add, poll-add  ... k번째 poll -> list 저장(que empty까지)
        int[] arr = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }// poll-add
            list.add(queue.poll());
        }
        bw.write("<");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i)+"");
            if (i < list.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();

    }
}
