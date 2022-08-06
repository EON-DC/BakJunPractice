package Silver3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int testCycle = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCycle; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int queueSize = Integer.parseInt(token.nextToken());
            int findOrder = Integer.parseInt(token.nextToken());
            Queue<Printer> queue = new LinkedList<>();
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < queueSize; j++) {
                boolean tag;
                if (j == findOrder) {
                    tag = true;
                } else tag = false;
                int order = Integer.parseInt(token.nextToken());
                Printer printer = new Printer(order, tag);
                queue.add(printer);
            }

            int orderCount = 0;
            Printer[] printers = new Printer[queueSize];

            while (!queue.isEmpty()) {

                int max = Integer.MIN_VALUE;
                for (int j = 0; j < queue.size(); j++) {
                    Printer temp = queue.poll();
                    queue.add(temp);
                    if (temp.order > max) {
                        max = temp.order;
                    }
                }
                Printer finder = queue.poll();
                if (finder.order == max) {
                    printers[orderCount] = finder;
                    orderCount++;
                } else {
                    queue.add(finder);
                }

            }
            // tag가 true인 printer의 인덱스 반환
            for (int j = 0; j < queueSize; j++) {
                if (printers[j].tag == true) {
                    bw.write((j + 1) + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Printer {
        int order;
        boolean tag;

        public Printer(int order, boolean tag) {
            this.order = order;
            this.tag = tag;
        }

        @Override
        public String toString() {
            return "Printer{" +
                    "order=" + order +
                    ", tag=" + tag +
                    '}';
        }
    }
}
