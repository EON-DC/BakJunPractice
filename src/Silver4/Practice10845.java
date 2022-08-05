package Silver4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int inputLine = Integer.parseInt(br.readLine());
        StringTokenizer token;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inputLine; i++) {
            token = new StringTokenizer(br.readLine());
            String command = token.nextToken();
            switch (command) {
                case "push":
                    int input = Integer.parseInt(token.nextToken());
                    queue.add(input);
                    //bw.write(input+"\n");
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        int temp = queue.peek();
                        bw.write(temp+"\n");
                    }else bw.write("-1"+"\n");
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        for (int j = 0; j < queue.size()-1; j++) {
                            int n = queue.poll();
                            queue.add(n);
                        }
                        int temp = queue.poll();
                        queue.add(temp);
                        bw.write(temp+"\n");
                    }else bw.write("-1"+"\n");
                    break;
                case "size":
                    int size = queue.size();
                    bw.write(size + "\n");
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        int temp = queue.poll();
                        bw.write(temp + "\n");
                    }else bw.write("-1"+"\n");

                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1"+"\n");
                    }else  bw.write("0"+"\n");
                    break;
            }
        }

        // 구현해야할 함수
        // push N
        // front
        // back
        // size
        // empty
        // pop
        // 입력 받고 함수로 연결


        bw.flush();
        bw.close();
        br.close();

    }

}
