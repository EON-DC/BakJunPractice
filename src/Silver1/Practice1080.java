package Silver1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[][] targetMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                targetMap[i][j] = Integer.parseInt(line[j]);
            }
        }
        boolean innerBreak = false;
        int countFlip = 0;
        Outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != targetMap[i][j]) {
                    boolean result = flip(map, i, j);
                    countFlip++;
                    if(!result){
                        innerBreak = true;
                        break Outer;
                    }
                }
            }
        }
        if (innerBreak) {
            bw.write("-1");
        }else{
            bw.write(countFlip+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static public boolean flip(int[][] map, int row, int col) {
        try {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (map[row + i][col + j] == 1) {
                        map[row + i][col + j] = 0;
                    } else {
                        map[row + i][col + j] = 1;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
