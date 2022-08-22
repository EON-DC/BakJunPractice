package Programmers;
import java.util.*;

public class P_12973 {

    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< s.length() ; i++){
            char temp = s.charAt(i);
            if(stack.isEmpty() || temp != stack.peek()){
                stack.push(temp);
            }else if(temp == stack.peek()){
                stack.pop();
            }
        }
        answer = stack.isEmpty()? 1 : 0;


        return answer;
    }
}

