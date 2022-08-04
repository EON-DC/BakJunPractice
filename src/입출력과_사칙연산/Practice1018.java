package 입출력과_사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1018 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        boolean[][] encodedBoard = encod(board, N, M);

        int min = 10000;
        if (N == 8 && M == 8) {
            bw.write(String.valueOf(getScore(encodedBoard)));
        } else {
            int[][] score = new int[N - 7][M - 7];
            for (int i = 0; i < N - 7; i++) {
                for (int j = 0; j < M - 7; j++) {
                    score[i][j] = getScore(getBoard(encodedBoard, i, j));
                    if (score[i][j] < min) {
                        min = score[i][j];
                    }
                }
            }
            bw.write("" + min);
        }

        bw.flush();
        bw.close();
        br.close();
        //System.out.println(Arrays.toString(score[1]));


    }

    private static boolean[][] getBoard(boolean[][] encodedBoard, int i, int j) {
        boolean[][] chessboard = new boolean[8][8];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessboard[x][y] = encodedBoard[x + i][y + j];
            }
        }

        return chessboard;
    }

    private static int getScore(boolean[][] board) {

        boolean flag = board[0][0];
        int countCase1 = 0;
        int countCase2 = 0;
        int count = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((board[x][y] && flag) || (!board[x][y] && !flag)) {
                    countCase1++; // 같은 것 개수
                }
                if ((board[x][y] && !flag) || (!board[x][y] && flag)) {
                    countCase2++; // 같은 것 개수
                }
                if (y < 7) {
                    flag = !flag; // 다음 반복시엔 반전 대조
                } // 마지막줄은 그대로
            }
        }
        count = (countCase1 > countCase2) ? countCase1 : countCase2;
        return 64 - count;

    }

    public static boolean[][] encod(char[][] arr, int N, int M) {
        boolean[][] boolArr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'W') {
                    boolArr[i][j] = true;
                } else {
                    boolArr[i][j] = false;
                }
            }
        }

        return boolArr;
    }

}