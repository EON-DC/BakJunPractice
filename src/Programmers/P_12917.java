package Programmers;

import java.util.*;
public class P_12917 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        for(String a : arr){
            builder.append(a);
        }
        return builder.toString();
    }
}
