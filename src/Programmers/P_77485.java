package Programmers;
import java.util.ArrayList;
public class P_77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int input = 1;
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = input;
                input++;
            }
        } // map 완성

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int[] query : queries) {
            int circul = circul(map, query);
            resultList.add(circul);
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    static public int circul(int[][] map, int[] query) {
        int minNum = 10001;
        for (int i = 0; i < 4; i++) {
            query[i]--;
        }
        int r1 = query[0];
        int c1 = query[1];
        int r2 = query[2];
        int c2 = query[3];

        int buffer = map[r1][c1];
        for (int i = c1 + 1; i <= c2; i++) {
            int temp = map[r1][i];
            map[r1][i] = buffer;
            buffer = temp;
            minNum = Math.min(minNum, temp);
        }
        for (int i = r1 + 1; i <= r2; i++) {
            int temp = map[i][c2];
            map[i][c2] = buffer;
            buffer = temp;
            minNum = Math.min(minNum, temp);
        }
        for (int i = c2 - 1; i >= c1; i--) {
            int temp = map[r2][i];
            map[r2][i] = buffer;
            buffer = temp;
            minNum = Math.min(minNum, temp);
        }
        for (int i = r2 - 1; i >= r1; i--) {
            int temp = map[i][c1];
            map[i][c1] = buffer;
            buffer = temp;
            minNum = Math.min(minNum, temp);
        }

        return minNum;
    }
}