package Programmers;
import java.util.*;

public class P_1844 {
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = BFS(0,0,maps, visited, row, col);
        return count;
    }

    public static int BFS (int x, int y, int[][] maps, boolean[][] visited, int row, int col){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int depth = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, depth});
        visited[x][y] = true;
        boolean isTouchedTarget = false;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == row-1 && temp[1] == col-1){
                depth = temp[2];
                isTouchedTarget = true;
                break;
            }
            for(int i = 0 ; i< 4; i++){
                int cx = temp[0] + dx[i];
                int cy = temp[1] + dy[i];

                if(cx>= 0 && cx < row && cy >= 0 && cy < col && !visited[cx][cy] && maps[cx][cy] == 1){
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy, temp[2]+1});
                }
            }
        }

        if(!isTouchedTarget){
            return -1;
        }

        return depth;
    }
}