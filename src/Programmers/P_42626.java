package Programmers;
import java.util.*;

public class P_42626 {

    public int solution(int[] scoville, int K) {
        int mixCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        while(true){
            if(pq.peek() >= K){
                break;
            }else if(pq.size()>=2){
                int e1 = pq.poll();
                int e2 = pq.poll();
                pq.add(e1 + e2*2);
                mixCount++;
            }else{
                return -1;
            }
        }

        return mixCount;
    }
}