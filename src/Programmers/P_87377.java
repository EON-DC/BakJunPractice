package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class P_87377 {
    static long maxX = -100001, minX = 100001, maxY = -100001, minY = 100001;

    public static void main(String[] args) {
        String[] answer = solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
        System.out.println("Arrays.toString(answer = " + Arrays.toString(answer));
    }

    static public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<Pair> list = new HashSet<>();
        for(int i = 0; i<line.length; i++){
            for(int j = i+1 ; j<line.length; j++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long ADBC = A*D - B*C;
                if(ADBC == 0){
                    continue;
                }
                double foundX, foundY;
                foundX = (double)(B*F - E*D) / ADBC;
                foundY = (double)(E*C - A*F) / ADBC;
                if(foundX %1 == 0 && foundY %1 == 0){
                    maxX = (long) Math.max(maxX, foundX);
                    minX = (long) Math.min(minX, foundX);
                    maxY = (long) Math.max(maxY, foundY);
                    minY = (long) Math.min(minY, foundY);
                    list.add(new Pair((long)foundX, (long)foundY));
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int row = (int)(maxY-minY) +1;
        int col = (int)(maxX-minX) +1;
        char[][] map = new char[row][col];
        for(int i = 0; i< row; i++){
            Arrays.fill(map[i], '.');
        }
        for(Pair pair : list){
            map[(int)(maxY - pair.y)][(int)(maxX - pair.x)] = '*';
        }

        answer = new String[row];
        int index = 0;
        for(int i = 0 ; i<row ; i++){
            builder = new StringBuilder();
            for(int j = 0; j< col ; j++){
                builder.append(map[i][j]);
            }
            answer[index++] = builder.toString();
        }

        return answer;
    }
    static class Pair{
        long x;
        long y;
        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this.getClass() != obj.getClass()) return false;
            return (((Pair) obj).x == this.x) && (((Pair) obj).y == this.y);
        }
    }


    // 교점 찾기
    // 정수인지 판별
    // 평행 또는 일치하는지
    // 교점의 위치를 보고 어떻게 * 와 . 으로 나타낼지?
}
