package Programmers;

import java.util.Stack;

public class P_12909 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            switch (c) {
                case '(':
                    stack.add(1);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        answer = false;
                        return answer;
                    } else {
                        stack.pop();
                    }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
            return answer;
        }

        return answer;
    }
}