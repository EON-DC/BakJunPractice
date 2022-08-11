package Silver1;

import java.io.*;

public class Practice1992 {


    // 쿼드트리
    // 분할정복 문제
    // 전체 탐색 -> 다른 것 찾으면 탐색 종료
    // 사분면 나누고 다시 각각에서 전탐
    // 같으면 그대로 출력
    // 나눌수 없는 크기가 되면 그대로 출력
    // 출력시엔 괄호 열닫 추가

    // 입력 인자 N(2의 제곱수) 1 ~ 64 범위
    // 문자열

    static int N;
    static int map[][];
    static StringBuilder builder;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j)-48; // 1 : asc num (49)  0: 48
            }
        }
        dc(0, 0, N);
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dc(int x, int y, int biggerN) {
        int size = biggerN / 2;
        int thisType = map[x][y];
        if (biggerN == 1) {
            builder.append(thisType);
        } else {
            boolean isSameType = true;
            Outer:
            for (int i = x; i < biggerN+x; i++) {
                for (int j = y; j < biggerN+y; j++) {
                    if (map[i][j] != thisType) {
                        isSameType = false;
                        break Outer;
                    }
                }
            }
            if (isSameType) {
                builder.append(thisType);
            } else {
                builder.append("(");
                for (int i = x; i < biggerN+x; i+=size) {
                    for (int j = y; j < biggerN+y; j+=size) {
                        dc(i, j, size);
                    }
                }
                builder.append(")");
            }
        }
    }
}
