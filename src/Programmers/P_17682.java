package Programmers;

public class P_17682 {
    public int solution(String dartResult) {
        int answer = getResult(dartResult);
        return answer;
    }

    public static int getResult(String s) {
        StringBuilder builder = new StringBuilder();
        int[] result = {0, 0, 0};
        int index = 0;
        int sum = 0;
        for(int i= 0 ; i< s.length() ; i++){
            switch(s.charAt(i)){
                case 'S':
                    result[index] += Integer.parseInt(builder.toString());
                    index++;
                    builder = new StringBuilder();
                    break;

                case 'D':
                    result[index] += Integer.parseInt(builder.toString())
                            *Integer.parseInt(builder.toString()); // 제곱
                    index++;
                    builder = new StringBuilder();
                    break;
                case 'T':
                    result[index] += Integer.parseInt(builder.toString())
                            *Integer.parseInt(builder.toString())
                            *Integer.parseInt(builder.toString()); // 세제곱
                    index++;
                    builder = new StringBuilder();
                    break;
                case '*':
                    index--; // S,D,T를 만나면 index가 다음칸을 위해 넘어가있으므로 조정 필요
                    result[index] *= 2;
                    if(index>=1){
                        result[index-1] *= 2;
                    }
                    index++;
                    break;
                case '#':
                    index--;
                    result[index] *= -1;
                    index++;
                    break;

                default:
                    builder.append(s.charAt(i)); // 숫자
            }

        }
        for(int i : result){
            sum += i;
        }
        return sum;
    }
}