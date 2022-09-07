package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> lt = new Stack<>();
        Stack<Character> rt = new Stack<>();

        char[] line = br.readLine().toCharArray();
        for(char c : line){
            lt.push(c);
        }

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            line = br.readLine().toCharArray();
            switch (line[0]) {
                case 'L':
                    if(!lt.isEmpty()){
                        rt.push(lt.pop());
                    }
                    break;
                case 'D':
                    if(!rt.isEmpty()){
                        lt.push(rt.pop());
                    }
                    break;
                case 'P':
                    lt.push(line[2]);
                    break;
                case 'B':
                    if(!lt.isEmpty()){
                        lt.pop();
                    }
                    break;
            }
        }

        while (!lt.empty()) {
            rt.push(lt.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!rt.empty()) {
            builder.append(rt.pop());
        }
        System.out.println(builder.toString());
    }
}
