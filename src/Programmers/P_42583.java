package Programmers;

import java.util.*;
public class P_42583 {
    public int solution(int bridge_length, int enableWeight, int[] truck_weights) {
        Stack<Truck> stack = new Stack<>();
        Deque<Truck> deque = new ArrayDeque<>();
        for(int i = truck_weights.length-1 ; i>=0  ; i--){
            stack.push(new Truck(truck_weights[i], 0));
        }
        int time = 0;
        while(!stack.isEmpty()){
            int loadingWeight = 0;

            if(!deque.isEmpty() && (time - deque.peek().boardTime) >= bridge_length){
                deque.poll();
            }
            for(Truck truck : deque){
                loadingWeight += truck.getWeight();
            }

            int nextWeight = stack.peek().getWeight();
            if(loadingWeight + nextWeight <= enableWeight){
                deque.offer(stack.pop().setBoardTime(time));
            }
            time++;
        }
        time += bridge_length;

        return time;
    }
    static class Truck{
        int weight;
        int boardTime;
        Truck(int weight, int boardTime){
            this.weight = weight;
            this.boardTime = boardTime;
        }
        private Truck setBoardTime (int time){
            this.boardTime = time;
            return this;
        }
        private int getWeight (){
            return this.weight;
        }

        @Override
        public String toString(){
            return "|| weight : " + weight + ",  boardTime :" + boardTime;
        }
    }
}
