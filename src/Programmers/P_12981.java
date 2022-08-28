package Programmers;

import java.util.*;
public class P_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> data = new HashSet<>();
        data.add(words[0]);
        for(int i = 1; i< words.length ; i++){

            // who's turn?
            int turn = (i+1) % n == 0 ? n : (i+1) % n;
            int turnNum = (i+n) / n ;
            // is right?
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || data.contains(words[i])){
                answer[0] = turn;
                answer[1] = turnNum;
                break;
            }
            // used word was saved
            data.add(words[i]);
        }
        return answer;
    }
}