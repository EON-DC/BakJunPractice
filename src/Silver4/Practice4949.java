package Silver4;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Practice4949 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Outer:
        while (true) {
            if (s.equals(".")) {
                break;
            }
            // 조건 분석 : 소괄호(50, 51), 대괄호(133, 135) 두종만
            // 길이는 100자 이하, 마침표를 만나면 문자 종료
            // string 을 쪼개서 앞에서부터 searching
            // 스택 1개만 열어서, 소괄호면 true, 대괄호면 false 넣고
            // 소괄호 닫을 때 맨 위가 false 들어와있으면 에러.
            // 닫힐 때마다, poll 하고, 마지막 size가 0이면 균형잡힌 문자열
            Stack<Character> Bracket = new Stack<>();
            char[] chars = s.toCharArray();
            Inner:
            for (int i = 0; i < s.length(); i++) {
                switch (chars[i]) {
                    case '(':
                        Bracket.add('s');
                        break;
                    case ')':
                        try {
                            if (Bracket.peek() == 's') {
                                Bracket.pop();
                            }else break Inner;
                            break;
                        } catch (EmptyStackException e) {
                            Bracket.add('f');
                            break Inner;
                        }
                    case '[':
                        Bracket.add('l');
                        break;
                    case ']':
                        try {
                            if (Bracket.peek() == 'l') {
                                Bracket.pop();
                            }else break Inner;
                            break;
                        } catch (EmptyStackException e) {
                            Bracket.add('f');
                            break Inner;
                        }
                    case '.':
                        break;
                }
            }
            if (Bracket.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            // 다음 문자열 받기
            s = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
