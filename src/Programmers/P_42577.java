package Programmers;

import java.util.*;
public class P_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> data = new HashSet<>();
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        for(String phoneNum : phone_book){
            for(int i = 0 ; i<= phoneNum.length(); i++){
                String testUnit = phoneNum.substring(0,i);
                if(data.contains(testUnit)){
                    return false;
                }
            }
            data.add(phoneNum);
        }
        return true;
    }
}