package Programmers;

import java.util.*;
public class P_12915 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, new Comparator<String>(){

            public int compare(String o1, String o2){
                if(o1.charAt(n) != o2.charAt(n)){
                    return o1.charAt(n) - o2.charAt(n);
                }else{
                    return o1.compareTo(o2);
                }
            }

        });

        answer = strings;

        return answer;
    }
}
