package Programmers;

import java.util.*;
public class P_17679 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] map = new int[board.length][board[0].length()];
        for(int i = 0; i< board.length ; i++){
            String line  = board[i];
            for(int j = 0; j < board[0].length() ; j++){
                map[i][j] = line.charAt(j) - 'A'+1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean hasBlockRemoved = true;
        while(hasBlockRemoved){
            hasBlockRemoved = false;
            for(int i = 0; i<map.length-1 ; i++){
                for(int j = 0 ; j < map[0].length-1 ; j++){
                    if(map[i][j] > 0){
                        int unit = map[i][j];
                        if(unit == map[i+1][j] && unit == map[i][j+1] && unit == map[i+1][j+1]){
                            hasBlockRemoved = true;
                            queue.add(new int[]{i, j});
                        }
                    }
                }
            }

            while(!queue.isEmpty()){
                int[] samePoint = queue.poll();
                int row = samePoint[0];
                int col = samePoint[1];
                map[row][col] = -1;
                map[row+1][col] = -1;
                map[row][col+1] = -1;
                map[row+1][col+1] = -1;
            }

            // map 정렬
            if(hasBlockRemoved){
                for(int j = 0; j < map[0].length ; j++){
                    Stack<Integer> stack = new Stack<>();
                    int minusCount = 0;
                    for(int i = map.length -1 ; i >= 0 ; i--){
                        if(map[i][j] != -1){
                            stack.push(map[i][j]);
                        }else{
                            minusCount++;
                        }
                    }
                    while(minusCount-->0){
                        stack.push(-1);
                    }
                    for(int i = 0; i< map.length ; i++){
                        map[i][j] = stack.pop();
                    }
                }
            }
        }
        int removedCount = 0;
        for(int i = 0; i<map.length ; i++){
            for(int j = 0 ; j < map[0].length ; j++){
                if(map[i][j] == -1){
                    removedCount++;
                }
            }
        }

        return removedCount;
    }
}