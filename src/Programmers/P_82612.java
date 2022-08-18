package Programmers;
import java.util.*;

public class P_82612 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long lprice = (long) price;
        long lmoney = (long) money;

        for(int i =1; i <= count ; i++){
            lmoney -= lprice*i;
        }
        if(lmoney<0){
            answer = lmoney * -1;
        }else{
            answer = 0;
        }


        return answer;
    }
}