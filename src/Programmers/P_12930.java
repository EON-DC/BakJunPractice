package Programmers;

import java.util.*;
public class P_12930 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.toLowerCase();
        int index = 0;
        for(int i = 0 ; i< s.length() ; i++){
            if(s.charAt(i) != ' '){
                if(index % 2 == 0){
                    builder.append((char)(s.charAt(i) - 32)+"");
                    index++;
                }else{
                    builder.append((char)s.charAt(i) + "");
                    index++;
                }
            }else{
                builder.append(" ");
                index = 0;
            }
        }
        return builder.toString();
    }

}