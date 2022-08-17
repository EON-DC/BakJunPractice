package Programmers;
import java.util.*;
public class P_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // hashmap 구조로 동일한 이름 나올경우 +1 시행, completion을 받으면 거기서 차감. remain만 출력
        HashMap<String, Integer> maps = new LinkedHashMap<>();

        for(String s : participant){
            if(maps.containsKey(s)){
                int temp = maps.get(s).intValue() + 1;
                maps.put(s, temp);
            }else{
                maps.put(s, 1);
            }
        }

        for(String s : completion){
            int temp = maps.get(s).intValue() - 1;
            if(temp == 0){
                maps.remove(s);
            }else{
                maps.put(s, temp);
            }
        }

        answer = maps.keySet().stream().findAny().get();


        return answer;
    }
}