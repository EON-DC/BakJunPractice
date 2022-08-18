package Programmers;

import java.util.*;
public class P_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String line = editFormat(Integer.toString(arr1[i],2), n);
            String line2 = editFormat(Integer.toString(arr2[i],2), n);
            for(int j = 0; j < n; j++){
                if(line.charAt(j) == '1'){
                    map[i][j]++;
                }
                if(line2.charAt(j) == '1'){
                    map[i][j]++;
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] >= 1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        answer = list.toArray(new String[0]);

        return answer;
    }

    public String editFormat(String s, int size){
        if(s.length()<size){
            StringBuilder builder = new StringBuilder();
            int needZero = size-s.length();
            for(int i = 0 ; i< needZero ; i++){
                builder.append("0");
            }
            builder.append(s);
            return builder.toString();
        }
        return s;
    }
}
