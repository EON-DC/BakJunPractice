package Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Practice18111 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(token.nextToken());
        int column = Integer.parseInt(token.nextToken());
        int inven = Integer.parseInt(token.nextToken());

        // 브르투포스
        // upper bound
        // 땅 평탄화, 크기 256 미만 -> 일단 int arr로 계산해보고 추후 char로 바꾸기
        // 블록제거는 2초, 블록 세우기는 1초
        // 만약 블록이 없으면? 블록제거 -> 세우기 순으로 작업
        // field와 height, inven을 주면, 시간을 계산해주는 함수 작성
        // main에서는 height 늘려보고, 줄여보고, 가장 작은 걸리는 시간 찾고 이전 결과값과 비교하여
        // 늘어날 경우, 검색을 중단 최저점을 리스트로 반환한다.

        int[][] field = new int[row][column];
        int min = 256, max = -1;
        for (int i = 0; i < row; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                field[i][j] = Integer.parseInt(token.nextToken());
                if (field[i][j] > max) {
                    max = field[i][j];
                }
                if (field[i][j] < min) {
                    min = field[i][j];
                }
            }
        }
        int minTimeResult = Integer.MAX_VALUE;
        int getHeight = 0;
        for (int i = 0; i <= 256; i++) {
            int timeResult = 0;
            int height = i;
            timeResult = getTime(field, inven, height, row, column);
            if (minTimeResult > timeResult) {
                minTimeResult = timeResult;
                getHeight = height;
            } else if (minTimeResult == timeResult) {
                if (getHeight < height) {
                    getHeight = height;
                }
            }
        }

        bw.write(minTimeResult+" "+getHeight);

        bw.flush();
        bw.close();
        br.close();

    }

    private static int getTime(int[][] field, int inven, int height, int row, int column) {
        int timeResult = 0;
        int inventory = inven;
        // int temp = field[i][j]-height
        // 양수이면 블록 깎아야하는 상황. 음수이면 인벤꺼 갖다가 써야하는 상황임
        //
        // 음수였을 때 인벤이 모자란가? 고려해야함
        // 경우1) 인벤이 풍족 : 블럭 세우기만 하면됨
        // 경우2) 인벤이 모자랄 경우 : 해당 height 불가 -> Integer max
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = field[i][j]-height;
                if (temp > 0) {
                    inventory += temp;
                    timeResult += Math.abs(temp)* 2 ;
                } else if (temp < 0) {
                    inventory += temp;
                    timeResult += Math.abs(temp);
                }
            }
        }
        if (inventory <0) {
            timeResult = Integer.MAX_VALUE;
        }
        return timeResult;
    }
}
