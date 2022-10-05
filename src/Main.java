import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pn = Integer.parseInt(br.readLine()); // point number
        while (pn-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            visited[a] = true;
            queue.add(a);
            Arrays.fill(command, "");
            while (!queue.isEmpty() && !visited[b]) {
                int now = queue.poll();
                int D = (2 * now) % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    command[D] = command[now] + "D";
                }

                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "L";
                }

                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }

            System.out.println(command[b]);
        }
    }
}