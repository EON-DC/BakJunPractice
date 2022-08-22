package Programmers;

public class P_43165 {
    public int solution(int[] numbers, int target) {

        // 만들 수 있는 경우의 수, Math.pow(2,numbers.length)
        // 배열로 만들기엔 메모리를 너무 많이 먹음
        // 1~Math.pow(2,numbers.length)
        // 탐색하면서 연산 값이 target에 들면 개수를 센다.
        int count = 0;
        for(int i = 0 ; i < (int)Math.pow(2,numbers.length); i++){
            String testUnit = Integer.toString(i, 2);
            while(testUnit.length() <numbers.length ){
                testUnit = "0" + testUnit;
            }
            if(verify(testUnit, numbers, target)){
                count++;
            }else{
                continue;
            }
        }
        return count;
    }

    public boolean verify(String s, int[] numbers, int target){
        int sum = 0;

        for(int i = 0; i< numbers.length ; i++){
            if(s.charAt(i) == '1'){
                sum += numbers[i];
            }
            if(s.charAt(i) == '0'){
                sum -= numbers[i];
            }
        }

        if(sum == target){
            return true;
        }
        return false;
    }
}