package Programmers;

public class P_12916 {
    boolean solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int pCounter = 0;
        int yCounter = 0;
        for(char c : chars){
            if(c == 'p'){
                pCounter++;
            }
            if(c == 'y'){
                yCounter++;
            }
        }
        if(pCounter==0 && yCounter == 0){
            return true;
        }
        if(pCounter == yCounter){
            return true;
        }
        return false;
    }
}
