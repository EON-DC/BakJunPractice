package Silver1;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Practice1074 {

    /**
     * 1074번, Z, 분할 정복 문제
     * 제공된 행렬을 4개의 4분면으로 구분한다.
     * size가 1이 될 때까지 시작 count를 누적시키면?
     */
    static int N, r, c, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        result = 0;
        quadDissec(r, c, (int) pow(2, N), 0);

        bw.write(result + "");

        bw.close();
        br.close();
    }

    public static void quadDissec(int r, int c, int biggerSize, int startCount) {
        // biggersize는 한 변 길이
        // bigger 가 1이면 함수 종료
        if (biggerSize == 1) {
            result = startCount;
        } else {
            // 변수 정의 및 위치 확인

            int mapSize = biggerSize / 2;
            int inclineSize = mapSize * mapSize;
            boolean isUpper = false;
            boolean isLeft = false;
            if (r < mapSize) {
                // 1, 2
                isUpper = true;
            }
            if (c < mapSize) {
                // 2, 3
                isLeft = true;
            }

            // dp
            if (isUpper && isLeft) {

                quadDissec(r, c, mapSize, startCount);
            }
            if (isUpper && !isLeft) {

                quadDissec(r , c- mapSize, mapSize, startCount + inclineSize);
            }
            if (!isUpper && isLeft) {

                quadDissec(r- mapSize, c, mapSize, startCount + inclineSize * 2);
            }
            if (!isUpper && !isLeft) {

                quadDissec(r - mapSize, c - mapSize, mapSize, startCount + inclineSize * 3);
            }
        }
    }


}
