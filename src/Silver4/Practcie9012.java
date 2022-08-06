package Silver4;

import java.io.*;
import java.util.Stack;

public class Practcie9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        Stack<Character> stack = new Stack<>();
        int cycle = Integer.parseInt(br.readLine());
        outer:
        for (int i = 0; i < cycle; i++) {
            stack.clear();
            String line = br.readLine();
            char[] arr = line.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    stack.add(arr[j]);
                } else if (arr[j] == ')'){
                    if (stack.isEmpty()) {
                        bw.write("NO\n");
                        continue outer;
                    }
                    char temp = stack.peek();
                    if (temp != '(') {
                        bw.write("NO\n");
                        continue outer;
                    } else stack.pop();
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
