package Programmers;

public class P_77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left ; i <= right ; i++){
            int tempResult = countYaksu(i);
            if( tempResult % 2 == 1){
                answer -= i;
            }else{
                answer += i;
            }
        }

        return answer;
    }

    static public int countYaksu(int n){
        int count = 0;
        for(int i =1 ; i<= n ; i++){
            if(n % i == 0){
                count++;
            }
        }
        return count;
    }
}
