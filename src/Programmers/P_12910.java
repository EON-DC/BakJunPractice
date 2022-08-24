package Programmers;

import java.util.*;
public class P_12910 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(a % divisor == 0){
                list.add(a);
            }
        }
        if(list.size() == 0){
            return new int[]{-1};
        }
        Collections.sort(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
