package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;

public class Practice11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCycle = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        while (testCycle-- > 0) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    Num polledNum = pq.poll();
                    if (polledNum.isPos) {
                        System.out.println(polledNum.num);
                    } else {
                        System.out.println(polledNum.num * -1);
                    }
                }
            } else {
                boolean isPos = (cmd > 0);
                pq.add(new Num((int) Math.abs(cmd), isPos));
            }
        }
    }

    static class Num implements Comparable<Num> {
        int num;
        boolean isPos;

        Num(int num, boolean isPos) {
            this.num = num;
            this.isPos = isPos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Num num1 = (Num) o;
            return num == num1.num && isPos == num1.isPos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, isPos);
        }

        @Override
        public int compareTo(Num o) {
            if (this.num == o.num) {
                int thisNum = this.isPos ? 1 : -1;
                int otherNum = o.isPos ? 1: -1;
                return thisNum-otherNum;
            }
            return this.num - o.num;
        }
    }
}
