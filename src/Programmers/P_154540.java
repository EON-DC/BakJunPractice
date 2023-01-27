package Programmers;

import java.util.*;

public class P_154540 {


    // String[]를 int[][]로 맵핑, 'X'는 -1으로 변환
    // 상하좌우 탐색하여 cell count
    // 새로운 sector를 찾을 경우 list 추가
    // cell 탐색이 끝난 곳은 visit 처리
    // 오름차순
    // list.size가 0일 경우는 -1로 배열 반환

    static int[][] mapped;
    static List<Integer> countList;
    static int row, col, sectorCount;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void mapper(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];
        mapped = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] oneRow = maps[i].split("");
            for (int j = 0; j < oneRow.length; j++) {
                if (oneRow[j].equals("X")) {
                    mapped[i][j] = -1;
                } else {
                    mapped[i][j] = Integer.parseInt(oneRow[j]);
                }
            }
        }
    }



    public static int[] solution(String[] test) {
        countList = new ArrayList<>();
        mapper(test);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mapped[i][j] != -1 && visited[i][j] == false) {
                    sectorCount = 0;
                    BFS(i, j);
                    countList.add(sectorCount);
                }
            }
        }
        if (countList.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(countList);
        return countList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int BFS(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        sectorCount += mapped[i][j];

        while (queue.size() != 0) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int cx = poll[0] + dx[k];
                int cy = poll[1] + dy[k];

                if (cx >= 0 && cx < row && cy >= 0 && cy < col && mapped[cx][cy] != -1 && visited[cx][cy] == false) {
                    BFS(cx, cy);
                }
            }
        }
        return sectorCount;

    }


}
