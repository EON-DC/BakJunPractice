package Programmers;
import java.util.*;
public class P_1845 {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int setSize = set.size();
        int halfN = nums.length/2;
        if(setSize >= halfN){
            answer = halfN;
        }else{ // 중복이 많아 종류가 N/2보다 작을 경우
            answer = setSize;
        }

        return answer;
    }
}