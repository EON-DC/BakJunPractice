package Programmers;
import java.util.*;
public class P_42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        for(int m = 0; m < commands.length ; m++){
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
            if(i == j){
                result.add(array[i-1]);
            }else{
                int[] temp = new int[j-i+1];
                int index = 0;
                for(int x = i-1 ; x < j ;x++){
                    temp[index] = array[x];
                    index++;
                }
                Arrays.sort(temp);
                System.out.println(Arrays.toString(temp));
                result.add(temp[k-1]);
            }
        }
        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
