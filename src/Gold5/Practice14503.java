package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice14503 {
    static String src = "11 10\n" +
            "7 4 0\n" +
            "1 1 1 1 1 1 1 1 1 1\n" +
            "1 0 0 0 0 0 0 0 0 1\n" +
            "1 0 0 0 1 1 1 1 0 1\n" +
            "1 0 0 1 1 0 0 0 0 1\n" +
            "1 0 1 1 0 0 0 0 0 1\n" +
            "1 0 0 0 0 0 0 0 0 1\n" +
            "1 0 0 0 0 0 0 1 0 1\n" +
            "1 0 0 0 0 0 1 1 0 1\n" +
            "1 0 0 0 0 0 1 1 0 1\n" +
            "1 0 0 0 0 0 0 0 0 1\n" +
            "1 1 1 1 1 1 1 1 1 1";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static boolean[][] hasCleanedMap;
    static int count = 0;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        d = Integer.parseInt(line[2]);

        map = new int[N][M];
        hasCleanedMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    hasCleanedMap[i][j] = true;
                }
            }
        }

        Cleaner cleaner = new Cleaner(r, c, d);
        cleaner.turnOn();

        System.out.println(count);
    }

    static class Cleaner {
        int curRow;
        int curCol;
        int curDirection; // 0: 북, 1: 동, 2: 남,  3: 서

        public Cleaner(int curRow, int curCol, int curDirection) {
            this.curRow = curRow;
            this.curCol = curCol;
            this.curDirection = curDirection;
        }

        public void turnOn() {
            int fourDirection = 0;
            while (true) {
                cleanUp();
                if (fourDirection == 4) {
                    if (canGoBack() == true) {
                        goBack();
                        fourDirection = 0;
                        continue;
                    } else {
                        return;
                    }
                }
                if (hasLeftSpace() == true && hasLeftCleaned() == false) {
                    turnLeft();
                    go();
                    fourDirection = 0;
                    continue;
                }
                if (hasLeftSpace() == false || hasLeftCleaned() == true) {
                    turnLeft();
                    fourDirection++;
                    continue;
                }


            }

        }

        public void turnLeft() {
            if (this.curDirection != 0) {
                this.curDirection -= 1;

            } else {
                this.curDirection = 3;
            }

        }

        public boolean canGoBack() {
            switch (curDirection) {
                case 0:
                    if (curRow + 1 < N - 1 && map[curRow + 1][curCol] == 0)
                        return true;
                    break;
                case 1:
                    if (curCol - 1 >= 1 && map[curRow][curCol - 1] == 0)
                        return true;
                    break;
                case 2:
                    if (curRow + 1 >= 1 && map[curRow - 1][curCol] == 0)
                        return true;
                    break;
                case 3:
                    if (curCol + 1 < M - 1 && map[curRow][curCol + 1] == 0)
                        return true;
                    break;
            }
            return false;
        }

        public void goBack() {
            switch (curDirection) {
                case 2:
                    curRow -= 1;
                    break;
                case 3:
                    curCol += 1;
                    break;
                case 0:
                    curRow += 1;
                    break;
                case 1:
                    curCol -= 1;
                    break;
            }
        }

        public void go() {
            switch (curDirection) {
                case 0:
                    curRow -= 1;
                    break;
                case 1:
                    curCol += 1;
                    break;
                case 2:
                    curRow += 1;
                    break;
                case 3:
                    curCol -= 1;
                    break;
            }
        }

        public boolean hasLeftCleaned() {
            switch (curDirection) {
                case 0:
                    if (hasCleanedMap[curRow][curCol - 1] == false) {
                        return false;
                    }
                    break;
                case 1:
                    if (hasCleanedMap[curRow - 1][curCol] == false) {
                        return false;
                    }
                    break;
                case 2:
                    if (hasCleanedMap[curRow][curCol + 1] == false) {
                        return false;
                    }
                    break;
                case 3:
                    if (hasCleanedMap[curRow + 1][curCol] == false) {
                        return false;
                    }
                    break;
            }
            return true;
        }

        public boolean hasLeftSpace() {
            switch (curDirection) {
                case 0:
                    if (curCol - 1 >= 1 && map[curRow][curCol - 1] == 0)
                        return true;

                    break;
                case 1:
                    if (curRow - 1 >= 1 && map[curRow - 1][curCol] == 0)
                        return true;

                    break;
                case 2:
                    if (curCol + 1 < M - 1 && map[curRow][curCol + 1] == 0)
                        return true;

                    break;
                case 3:
                    if (curRow + 1 < N - 1 && map[curRow + 1][curCol] == 0)
                        return true;

                    break;
            }
            return false;
        }

        public void cleanUp() {
            if (hasCleanedMap[curRow][curCol] == false) {
                hasCleanedMap[curRow][curCol] = true;
                count += 1;
            }
        }
    }
}

