package Programmers;
import java.util.*;

public class P_81302 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int index = 0;
        for(String[] room : places){
            String[][] map = new String[5][5];
            for(int row = 0 ; row < 5 ; row++){
                String[] line = room[row].split("");
                for(int col = 0 ; col < 5 ; col++){
                    map[row][col] = line[col];
                }
            } // map 채우기 완

            boolean innerBreakUsed = false;
            Outer:
            for(int row = 0; row< 5 ; row++){
                for(int col = 0; col < 5 ; col++){
                    if(map[row][col].equals("P")){
                        boolean[][] visited = new boolean[5][5];
                        boolean result = BFS(map, row, col, visited);
                        if(!result){
                            innerBreakUsed = true;
                            break Outer;
                        }
                    }
                }
            }

            if(innerBreakUsed){
                answer[index++] = 0;
            }else{
                answer[index++] = 1;
            }
        }
        return answer;
    }
    public static boolean BFS(String[][] map, int row, int col, boolean[][] visited){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 0 ; i< 4 ; i++){
                int cx = temp[0] + dx[i];
                int cy = temp[1] + dy[i];

                int distance = (int)Math.abs(cx - row) + (int) Math.abs(cy - col);
                if(distance > 2 || distance == 0){
                    continue;
                }
                if(cx < 5 && cy < 5 && cx >= 0 && cy >= 0 && !visited[cx][cy]){
                    String testUnit = map[cx][cy];
                    switch(testUnit){
                        case "P":
                            return false;
                        case "X":
                            continue;
                        case "O":
                            visited[cx][cy] = true;
                            queue.add(new int[]{cx,cy});
                            continue;
                    }
                }

            }

        }
        return true;
    }
}