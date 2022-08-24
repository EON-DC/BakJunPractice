package Programmers;

public class P_12921 {
    public int solution(int n) {
        int answer = 0;
        if(n == 1){
            return 0;
        }

        for(int i = 2 ; i <= n ; i++ ){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(int a){
        for(int i = 2 ; i<= (int)Math.sqrt(a) ; i++){
            if( a % i == 0){
                return false;
            }
        }
        return true;
    }
}
