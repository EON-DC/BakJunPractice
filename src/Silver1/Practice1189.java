package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice1189 {
    static String src = "3 4 6\n" +
            "....\n" +
            ".T..\n" +
            "....";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>(); // store에 저장될 때, 거리만 저장할 예정, 요구하는 거리의 개수만 카운트해줌
    static char[][] map;
    static boolean[][] visited;
    static int row, col, K;
    static int startRow, startCol, endRow, endCol;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));
        String[] firstLine = br.readLine().split(" ");
        row = Integer.parseInt(firstLine[0]);
        col = Integer.parseInt(firstLine[1]);
        K = Integer.parseInt(firstLine[2]);
        map = new char[row][col];
        visited = new boolean[row][col];
        startRow = row - 1;
        startCol = 0;
        endRow = 0;
        endCol = col - 1;

        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'T') {
                    visited[i][j] = true;
                }
            }
        }
        visited[startRow][startCol] = true;
        searchRoute(startRow, startCol, 1);
//        System.out.println("list = " + list);
//
        System.out.println(list.stream().filter(i -> i.equals(K)).count());
    }

    public static void searchRoute(int curRow, int curCol, int distance) {
        if (curRow == endRow && curCol == endCol) {
            list.add(distance);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = curRow + dx[i];
            int cy = curCol + dy[i];

            if (cx >= 0 && cx < row && cy >= 0 && cy < col
                    && map[cx][cy] != 'T' && visited[cx][cy] == false) {
                visited[cx][cy] = true;
                searchRoute(cx, cy, distance + 1);
                visited[cx][cy] = false;
            }
        }
    }
}

