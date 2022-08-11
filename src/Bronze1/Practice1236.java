package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1236 {
    // 교차로 막기 때문에, 세로 빵꾸 개수, 가로 빵꾸 개수 중에 큰거 골라주면 됨

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if ((line.charAt(j) - '.') == 0) {
                    map[i][j] = 0;
                } else map[i][j] = 1;
            }
        }
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            int tempCount = 0;
            for (int j = 0; j < M; j++) {
                tempCount += map[i][j]; // 병정 서있으면 0이상
            }
            if (tempCount == 0) {
                rowCount++;
            }
        }
        for (int j = 0; j < M; j++) {
            int tempCount = 0;
            for (int i = 0; i < N; i++) {
                tempCount += map[i][j];
            }
            if (tempCount == 0) {
                colCount++;
            }
        }
        bw.write(Math.max(rowCount, colCount) + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
