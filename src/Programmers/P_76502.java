package Programmers;

import java.util.*;
public class P_76502 {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length() ; i++){
            StringBuilder builder = new StringBuilder();
            builder.append(s.substring(i)).append(s.substring(0, i));
            String temp = builder.toString();
            if(verify(temp)){
                answer++;
            }
        }
        return answer;
    }
    public static boolean verify(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length() ;i++){
            switch(s.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(stack.peek() == '('){
                        stack.pop();
                    }else return false;
                    break;
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else return false;
                    break;
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(stack.peek() == '['){
                        stack.pop();
                    }else return false;
                    break;
            }
        }// 쌓기만 하여 stack이 잔존한 경우
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}