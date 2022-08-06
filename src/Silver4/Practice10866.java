package Silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Practice10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int inputLine = Integer.parseInt(br.readLine());
        StringTokenizer token;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inputLine; i++) {
            token = new StringTokenizer(br.readLine());
            String command = token.nextToken();
            switch (command) {
                case "push_back":
                    int back = Integer.parseInt(token.nextToken());
                    deque.addLast(back);
                    break;
                case "push_front":
                    int front = Integer.parseInt(token.nextToken());
                    deque.addFirst(front);
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        int pollFront = deque.pollFirst();
                        bw.write(pollFront + "\n");
                    } else bw.write("-1\n");
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        int pollBack = deque.pollLast();
                        bw.write(pollBack + "\n");
                    } else bw.write("-1\n");
                    break;
                case "size":
                    int size = deque.size();
                    bw.write(size + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write( "1\n");
                    }else bw.write("0\n");
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        int peekFront = deque.peekFirst();
                        bw.write(peekFront + "\n");
                    } else bw.write("-1\n");
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        int peekBack = deque.peekLast();
                        bw.write(peekBack + "\n");
                    } else bw.write("-1\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
