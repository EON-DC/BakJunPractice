package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P_12937 {

    public String solution(int num) {
        String answer = "";
        if (num < 0) {
            num *= -1;
        }
        if (num % 2 == 1) {
            answer = "Odd";
        } else {
            answer = "Even";
        }
        return answer;
    }
}
