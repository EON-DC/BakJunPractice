package Programmers;
import java.util.*;

public class P_12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        // 오름차순으로 sorting 후 남은 budget으로 지원할 수 있는지 확인 후 가능하면 answer +1, 불가능하면 return
        Arrays.sort(d);
        for(int i = 0; i< d.length ; i++){
            if(d[i] <= budget) {
                budget -= d[i];
                answer += 1;
            }else
                break;
        }

        return answer;
    }
}
