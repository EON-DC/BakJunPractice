package Programmers;

import java.util.regex.*;
public class P_12918 {
    public boolean solution(String s) {
        boolean answer = Pattern.matches("^\\d{4}$||^[0-9]{6}$",s);
        return answer;
    }
}
