package Bronze1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice1268 {

    // 1268번
    // 가장 많은 접촉이 있는 학생
    // 일단 맵으로 받아서 column 별로 탐색하면서 세트에 넣고
    // 세트 크기가 가장 큰 사람의 인덱스를 +1 해서 반환한다.

    static int[][] map;
    static int people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        people = Integer.parseInt(br.readLine());
        map = new int[people][5];
        for (int i = 0; i < people; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        int indexSaver = -1;

        for (int i = 0; i < people; i++) {
            int tempResult = searching(map, i);
            if (max < tempResult) {
                indexSaver = i;
                max = tempResult;
            }
        }
        indexSaver++;

        bw.write(indexSaver+"");


        bw.flush();
        bw.close();
        br.close();
    }

    private static int searching(int[][] map, int index) {
        Set<Integer> set = new HashSet<>();
        for (int l = 0; l < 5; l++) {
            int temp = map[index][l];
            for (int i = 0; i < people; i++) {
                if (temp == map[i][l]) {
                    set.add(i);
                }
            }
        }
        int result = set.size();
        return result;
    }


}