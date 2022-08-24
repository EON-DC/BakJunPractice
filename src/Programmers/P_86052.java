package Programmers;
import java.util.*;

public class P_86052 {
    public int[] solution(String[] grid) {
        int[] answer = {};
        int row = grid.length;
        int col = grid[0].length();
        char[][] map = new char[row][col];
        for(int i = 0; i< row; i++){
            char[] line = grid[i].toCharArray();
            for(int j = 0; j< col; j++){
                map[i][j] = line[j];
            }
        } // map 그리기 완
        int dimension = 4;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][][] visited = new boolean[row][col][dimension];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                for(int k = 0 ; k < dimension ; k++){
                    if(!visited[i][j][k]){
                        int count = light(map, visited, i, j, k, row, col);
                        list.add(count);
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int light(char[][] map, boolean[][][] visited, int i, int j, int k,
                            int row, int col){
        int count = 0;
        int[] dx = {1, 0, -1, 0}; // 위 오른쪽 아래 왼쪽 순
        int[] dy = {0, 1, 0, -1};

        while(true){
            if(visited[i][j][k]){
                //똑같은 코스를 돌게 되므로 정지
                break;
            }
            visited[i][j][k] = true;
            count++;

            // K에 대한 처리
            if(map[i][j] == 'L'){
                switch(k){
                    case 0:
                        k = 3;
                        break;
                    case 1:
                        k = 0;
                        break;
                    case 2:
                        k = 1;
                        break;
                    case 3:
                        k = 2;
                        break;
                }
            }
            if(map[i][j] == 'R'){
                switch(k){
                    case 0:
                        k = 1;
                        break;
                    case 1:
                        k = 2;
                        break;
                    case 2:
                        k = 3;
                        break;
                    case 3:
                        k = 0;
                        break;
                }
            }

            i = (i+dx[k]+row) % row; // 맵을 벗어나는 것 막기 위해 나머지로 저장
            j = (j+dy[k]+col) % col;

        }


        return count;
    }
}