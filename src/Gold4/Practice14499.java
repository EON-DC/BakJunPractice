package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice14499 {
    static String src = "3 3 0 0 16\n" +
            "0 1 2\n" +
            "3 4 5\n" +
            "6 7 8\n" +
            "4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, x, y, K;
    static int[][] map;
    static int[] order;

    static List<Integer> topList = new ArrayList<>();
    static Dice dice;


    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        x = Integer.parseInt(line[2]);
        y = Integer.parseInt(line[3]);
        K = Integer.parseInt(line[4]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        order = new int[K];
        line = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(line[i]);
        }

        dice = new Dice(x, y);
        for (int i = 0; i < K; i++) {
            dice.rotate(order[i]);
        }

//        System.out.println(topList);

        for (int top : topList) {
            System.out.println(top);
        }


    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int a : map[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println(" ----- ");
    }

    static class Dice {
        int top = 0;
        int east = 0;
        int west = 0;
        int north = 0;
        int south = 0;
        int bottom = 0;
        int curPosX = 0;
        int curPosY = 0;

        public Dice(int curPosX, int curPosY) {
            this.curPosX = curPosX;
            this.curPosY = curPosY;
        }

        public void rotate(int direction) {
            if (!verify(direction)) return;
            int temp = 0;
            switch (direction) {
                case 1: // 동쪽
                    curPosY += 1;

                    temp = top;
                    top = east;
                    east = bottom;
                    bottom = west;
                    west = temp;

                    break;

                case 2: // 서쪽
                    curPosY -= 1;


                    temp = top;
                    top = west;
                    west = bottom;
                    bottom = east;
                    east = temp;

                    break;
                case 3: // 북쪽
                    curPosX -= 1;

                    temp = top;
                    top = south;
                    south = bottom;
                    bottom = north;
                    north = temp;
                    break;
                case 4: // 남쪽
                    curPosX += 1;

                    temp = top;
                    top = north;
                    north = bottom;
                    bottom = south;
                    south = temp;
                    break;
            }

            copy();
            print();
//            printMap();

        }

        public void copy() {
            if (map[this.curPosX][this.curPosY] == 0) {
                map[this.curPosX][this.curPosY] = this.bottom;
            } else {
                this.bottom = map[this.curPosX][this.curPosY];
                map[this.curPosX][this.curPosY] = 0;
            }

        }

        public void print() {
            topList.add(this.top);
        }

        public boolean verify(int direction) {
            switch (direction) {
                case 1: // 동쪽
                    if (curPosY + 1 < M) {
                        return true;
                    }
                    break;
                case 2: // 서쪽
                    if (curPosY - 1 >= 0) {
                        return true;
                    }
                    break;
                case 3: // 북쪽
                    if (curPosX - 1 >= 0) {
                        return true;
                    }
                    break;
                case 4: // 남쪽
                    if (curPosX + 1 < N) {
                        return true;
                    }
                    break;

            }
            return false;
        }
    }
}
