package Programmers;

import java.util.*;
public class P_60058 {
    public String solution(String p) {
        String answer = "";
        if(rightPosition(p)){
            return p;
        }
        answer = divider(p);

        return answer;
    }

    static public boolean rightPosition(String s){
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if( c== '('){
                stack.add('(');
            }else if( c== ')' && !stack.isEmpty()) {
                stack.pop();
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    static public String divider(String s){
        if(rightPosition(s) || s.length() == 0){
            return s;
        }
        String divided = "";
        int leftCount = 0; // meaning of '('
        int rightCount = 0; // meaning of ')'
        int dividingIndex = 0;
        for(int i= 0  ; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                leftCount++;
            }else{
                rightCount++;
            }

            if(leftCount == rightCount){
                dividingIndex = i;
                break;
            }
        }
        String u = s.substring(0,dividingIndex+1);
        String v = s.substring(dividingIndex+1);

        if(rightPosition(u)){
            divided = u + divider(v);
        }else{
            divided = "(" + divider(v) +")";
            u = u.substring(1,u.length()-1);
            divided = divided + reverse(u);
        }
        return divided;
    }

    static public String reverse(String s){
        String result = "";
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '('){
                result = result + ")";
            }else{
                result = result + "(";
            }
        }
        return result;
    }

}
