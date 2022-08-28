package Programmers;

public class P_77885 {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index =0;
        for(long num : numbers){
            long depth = 0;
            long test = num+(long)Math.pow(2,depth);

            while(true){
                if(counter(num, test)){
                    answer[index++] = test;
                    break;
                }
                depth++;
                test = num+(long)Math.pow(2,depth) - (long)Math.pow(2,depth-1);
            }
        }
        return answer;
    }
    public static boolean counter(long num, long test){
        int differCnt = 0;
        String numVal = Long.toString(num, 2);
        String testVal = Long.toString(test, 2);
        if(numVal.length() != testVal.length()){
            while(numVal.length() != testVal.length()){
                numVal = "0"+numVal;
            }
        }
        for(int i = 0; i< numVal.length() ; i++){
            if(numVal.charAt(i) != testVal.charAt(i)){
                differCnt++;
            }
        }
        if(differCnt <= 2){
            return true;
        }
        return false;
    }
}