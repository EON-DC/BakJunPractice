package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice1059 {


    /**
     * 1059번 좋은구간
     * 집합 S과 n 이 주어지면, S의 원소들을 비해 이룰 수 있는 구간을 upperBound, lowerBound
     * 방식으로 찾아간다. 이룰 수 있는 경우의 수는 upperCount * lowerCount
     * upper의 범위는 n~upperbound
     * lower의 범위는 lowerbound~n
     * lowercount > 1 일경우 (n * n)으로 중복되는 케이스를 제하기 위해 -1을 한다.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sSize = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sSize; i++) {
            list.add(Integer.parseInt(token.nextToken()));
        }
        Collections.sort(list);
        int n = Integer.parseInt(br.readLine());
        int upperNearest, lowerNearest, indexFrontHasN = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                System.out.println("0");
                return;
            }
            if (list.get(i) > n) {
                indexFrontHasN = i;
                break;
            }
        }
        if (indexFrontHasN == 0) {
            lowerNearest = 0;
        } else {
            lowerNearest = list.get(indexFrontHasN - 1);
        }
        upperNearest = list.get(indexFrontHasN);
        int upperCount = upperNearest - n;
        int lowerCount = n - lowerNearest;
//
//        System.out.println("upperNearest = " + upperNearest);
//        System.out.println("upperCount = " + upperCount);
//        System.out.println("lowerNearest = " + lowerNearest);
//        System.out.println("lowerCount = " + lowerCount);
        int result = upperCount * lowerCount - 1;
        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}