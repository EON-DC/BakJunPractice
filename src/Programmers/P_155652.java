package Programmers;

import java.io.IOException;

public class P_155652 {

    public static String solution(String s, String skip, int index) {
        char[] word = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : word) {
            int innerIndex = 0;
            char changed = c;
            while (innerIndex != index) {
                changed += 1;
                if (changed == '{') {
                    changed = 'a';
                }
                if (skip.contains(Character.toString(changed))) {
                    continue;
                } else {
                    innerIndex++;
                }
            }
            sb.append(changed);
        }
        return sb.toString();
    }

    /**
     * s	skip	index	result
     * "aukks"	"wbqd"	5	"happy"
     */


    public void main(String[] args) throws IOException {
        String result = solution("aukks", "wbqd", 5);
        System.out.println(result);
    }

}
