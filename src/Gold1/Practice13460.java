package Gold1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice13460 {


    static int row, col;
    static boolean[][][][] visited;
    static int count;
    static char[][] map;
    static int holeX, holeY;
    static Marble blue, red;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void starter() {
        String test1 = "5 5\n" +
                "#####\n" +
                "#..B#\n" +
                "#.#.#\n" +
                "#RO.#\n" +
                "#####";

        String test2 = "7 7\n" +
                "#######\n" +
                "#...RB#\n" +
                "#.#####\n" +
                "#.....#\n" +
                "#####.#\n" +
                "#O....#\n" +
                "#######";

        String test3 = "7 7\n" +
                "#######\n" +
                "#..R#B#\n" +
                "#.#####\n" +
                "#.....#\n" +
                "#####.#\n" +
                "#O....#\n" +
                "#######";

        String test4 = "3 10\n" +
                "##########\n" +
                "#.O....RB#\n" +
                "##########";

        int result1 = solution(test1);
        int result2 = solution(test2);
        int result3 = solution(test3);
        int result4 = solution(test4);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

    }

    public static int solution(String input) {
        Queue<String> inputLine = new LinkedList<>(Arrays.asList(input.split("\n")));
        String[] firstLine = inputLine.poll().split(" ");
        row = Integer.parseInt(firstLine[0]);
        col = Integer.parseInt(firstLine[1]);
        map = new char[row][col];
        visited = new boolean[row][col][row][col];
        for (int i = 0; i < row; i++) {
            String poll = inputLine.poll();
            for (int j = 0; j < col; j++) {
                map[i][j] = poll.charAt(j);

                if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }

        return bfs();

    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;
        while (!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if (curCnt > 10) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    if (newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                while (map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    if (newBx == holeX && newRy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) {
                    continue;
                }

                if (isRedHole && !isBlueHole) {
                    return curCnt;
                }

                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) {
                        if (curRx > curBx) newBx -= dx[i];
                        else newRx -= dx[i];
                    } else if (i == 1) {
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if (i == 2) {
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else {
                        if (curRy < curBy) newRy -= dx[i];
                        else newBy -= dy[i];
                    }
                }

                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }

    static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Marble(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}

