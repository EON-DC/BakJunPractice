package Programmers;
import java.util.*;

public class P_1829 {
    public static void main(String[] args) {
        int[] sol = solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println("Arrays.toString(sol) = " + Arrays.toString(sol));
    }

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        /*
         * BFS 탐색을 통해 면적 확인
         * 탐색하면서 전체 영역 누적
         * 탐색 조건은 상하좌우만 비교
         *
         * 탐색이 끝나면 numberOfArea++;
         * maxSizeOfOneArea 와 비교하여 큰 것 저장
         */
        boolean[][] visited = new boolean[m][n];
        for(int row = 0 ; row < m ; row++){
            for(int col = 0; col < n ; col++){
                int cellColor = picture[row][col];
                if(cellColor != 0){
                    if(!visited[row][col]){
                        int area = BFS(picture, visited, row, col, dx, dy, 0, cellColor);
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(area, maxSizeOfOneArea);
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static public int BFS(int[][] picture, boolean[][] visited, int x, int y, int[] dx, int[] dy, int areaSize, int cellColor){
        Queue<Integer[]> q = new LinkedList<>();
        visited[x][y] = true;
        areaSize++;
        q.add(new Integer[]{x, y});
        while(!q.isEmpty()){
            int[] temp = Arrays.stream(q.poll()).mapToInt(Integer::intValue).toArray();
            int tx = temp[0];
            int ty = temp[1];
            for(int i =0 ; i< 4 ; i++){
                int cx = tx + dx[i];
                int cy = ty + dy[i];
                if(cx >= 0 && cy >= 0 && cx < picture.length && cy < picture[0].length && !visited[cx][cy] && picture[cx][cy] == cellColor){
                    q.add(new Integer[]{cx, cy});
                    visited[cx][cy] = true;
                    areaSize++;
                }
            }
        }
        return areaSize;

    }
}
