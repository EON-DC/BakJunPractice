package Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice12100 {
    static String src = "7\n" +
            "2 2 2 2 2 2 2\n" +
            "2 0 2 2 2 2 2\n" +
            "2 0 2 2 2 2 2\n" +
            "2 0 2 2 2 2 2\n" +
            "2 2 2 0 2 2 2\n" +
            "2 2 2 2 2 2 0\n" +
            "2 2 2 2 2 2 0"; // answer 32
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static int N;
    static List<Integer> orders = new ArrayList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
//        printBoard(board);
        DFS(5);
        System.out.println(result);


    }
    // 상하좌우 5번 움직임 브루트포스 해보고, 그에 따라 시뮬해보는 것

    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static int[][] getBoard() {
        int[][] cloneBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cloneBoard[i][j] = board[i][j];
            }
        }
        return cloneBoard;
    }

    public static void DFS(int depth) {
        if (depth == 0) {
            int[][] copyBoard = getBoard();
            for (int order : orders) {
                switch (order) {
                    case 1:
                        moveTop(copyBoard);

                        break;
                    case 2:
                        moveLeft(copyBoard);

                        break;
                    case 3:
                        moveRight(copyBoard);

                        break;
                    case 4:
                        moveBottom(copyBoard);

                        break;
                }
            }
            int cloneMax = getMax(copyBoard);
//            System.out.println("cloneMax = " + cloneMax);
            result = Math.max(cloneMax, result);


            return;
        }

        for (int i = 1; i < 5; i++) {
            orders.add(i);
            DFS(depth - 1);
            orders.remove(orders.size() - 1);
        }
    }

    static int getMax(int[][] clone) {
        int cloneMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cloneMax = Math.max(cloneMax, clone[i][j]);
            }
        }
        return cloneMax;
    }

    static void moveLeft(int[][] board) {
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    queue.add(board[i][j]);
                    board[i][j] = 0;
                }
            }
            List<Integer> list = calculate(queue);
            int index = 0;
            for (int src : list) {
                board[i][index++] = src;
            }
        }
    }

    static void moveRight(int[][] board) {
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    queue.add(board[i][j]);
                    board[i][j] = 0;
                }
            }
            List<Integer> list = calculate(queue);
            int index = N - 1;
            for (int src : list) {
                board[i][index--] = src;
            }
        }
    }

    static void moveTop(int[][] board) {
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (board[j][i] != 0) {
                    queue.add(board[j][i]);
                    board[j][i] = 0;
                }
            }
            List<Integer> list = calculate(queue);
            int index = 0;
            for (int src : list) {
                board[index++][i] = src;
            }
        }
    }

    static void moveBottom(int[][] board) {
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    queue.add(board[j][i]);
                    board[j][i] = 0;
                }
            }
            List<Integer> list = calculate(queue);
            int index = N - 1;
            for (int src : list) {
                board[index--][i] = src;
            }
        }
    }

    public static List<Integer> calculate(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (queue.peek() != null && temp == queue.peek()) {
                temp += queue.poll();
            }
            list.add(temp);
        }
        return list;
    }
}

