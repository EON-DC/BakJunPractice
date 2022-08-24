package Programmers;
import java.util.*;

public class P_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> queue = new LinkedList<>();
        for(int i = 0 ; i< priorities.length ;i++){
            queue.offer(new Print(priorities[i], i));
        }
        ArrayList<Print> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int maxPriority = 0;
            for(int i = 0; i< queue.size() ; i++){
                Print temp = queue.poll();
                queue.offer(temp);
                maxPriority = Math.max(maxPriority, temp.priority);
            }
            while(queue.peek().priority != maxPriority){
                Print temp = queue.poll();
                queue.offer(temp);
            }
            // priority가 가장 높은 것이 위로 온 상태
            list.add(queue.poll()); // 리스트로 추가 후 queue가 빌 때까지 반복
        }
        int index = 1;
        for(Print print : list){
            if(print.location == location){
                answer = index;
            }
            index++;
        }

        return answer;
    }

    static class Print{
        int priority;
        int location;
        Print(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
}