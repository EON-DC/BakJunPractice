package Programmers;

public class P_12903 {

    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) { // 4글자면 index 1,2
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else { // 5글자면 index 2
            answer = String.valueOf(s.charAt(s.length() / 2));
        }
        return answer;
    }
}
