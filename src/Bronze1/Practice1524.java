package Bronze1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice1524 {

    //1524 문제
    // 세준 N, 세비 M
    // 테스트 케이스 T
    // 각전투에서 살아있는 제일 약한 병사 임의의 1명이 죽음,
    // 만약 제일 약한 병사가 여러명이고  양편에 모두 있으면, 세비 약한 병사만 한명 죽음

    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            br.readLine();
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            ArrayList<Integer> jun = new ArrayList<>();
            ArrayList<Integer> bin = new ArrayList<>();
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                jun.add(Integer.parseInt(token.nextToken()));
            }
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bin.add(Integer.parseInt(token.nextToken()));
            }

            int junMax = jun.stream()
                    .max((o1, o2) -> o1.compareTo(o2)).get();
            int binMax = bin.stream()
                    .max((o1, o2) -> o1.compareTo(o2)).get();
            if (junMax > binMax) {
                bw.write("S\n");
            } else if (junMax < binMax) {
                bw.write("B\n");
            } else if (junMax == binMax) {
                bw.write("S\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
