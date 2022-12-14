package Programmers;

import java.util.Arrays;

public class P_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0 ; i < lost.length; i++){
            int lostOne = lost[i];
            for(int j = 0; j < reserve.length ; j++){
                if(reserve[j] == lostOne){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        } // 자기 자신 것은 먼저 찾음

        for(int i = 0; i< lost.length ; i++){
            if(lost[i]>0){
                for(int j = 0; j < reserve.length ; j++){
                    if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
                        answer++;
                        lost[i] = -1;
                        reserve[j] = -1;
                    }
                }
            }
        }// 앞에서부터 남는 것 없이 빌려감

        return answer;
    }
}