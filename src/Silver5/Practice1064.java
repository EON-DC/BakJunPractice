package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class Practice1064 {

    /**
     * 1064번 평행사변형
     * A, B, C가 주어질 때, D점을 찾고,
     * 평행사변형의 가장 큰 둘레와 작은 둘레의 차이를 계산한다.
     * AB 를 중선으로 할 때, BC, CA를 중선으로 할때 3가지임
     * 그리고 각각의 둘레는 2* (AB+AC), 2*(BA+BC), 2*(CA, CB)
     * 최대는? 가장 큰것 + 중간 조합
     * 최소는? 가장 작은것 + 중간 조합
     * 이들의 차는 ? (가장 큰것 - 가장 작은 것) *2
     * <p>
     * if Case2)
     * 만약 평행사변형을 만들 수 없는 경우엔, -1을 출력한다.
     * -> 세 점이 한 변에 있는 경우
     * 기울기가 같으면 한 변
     */
    static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double parallelogram(Pointer A, Pointer B, Pointer C) {
        double result;
//        double inclineAB, inclineAC, inclineBC;
//        try {
//            inclineAB = (A.y - B.y) / (A.x - B.x);
//        } catch (Exception e) {
//            inclineAB = Double.MAX_VALUE;
//        }
//        try {
//            inclineAC = (A.y - C.y) / (A.x - C.x);
//        } catch (Exception e) {
//            inclineAC = Double.MAX_VALUE;
//        }
//        try {
//            inclineBC = (B.y - C.y) / (B.x - C.x);
//        } catch (Exception e) {
//            inclineBC = Double.MAX_VALUE;
//        }
//        if (Math.abs(inclineAB - inclineBC)< 0.0000000001
//                && Math.abs(inclineBC - inclineAC)< 0.0000000001) {
//            result = -1;
//            return result;
//        }
        if ((A.y - B.y) * (A.x - C.x) == (A.x - B.x) * (A.y - C.y)
                && (A.y - C.y) * (B.x - C.x) == (B.y - C.y) * (A.x - C.x)) {
            result = -1;
            return result;
        }


        double lengthAB = sqrt(pow(abs(A.x - B.x), 2) + pow(abs(A.y - B.y), 2));
        double lengthAC = sqrt(pow(abs(A.x - C.x), 2) + pow(abs(A.y - C.y), 2));
        double lengthBC = sqrt(pow(abs(B.x - C.x), 2) + pow(abs(B.y - C.y), 2));
        ArrayList<Double> list = new ArrayList<>();
        list.add(lengthAB);
        list.add(lengthAC);
        list.add(lengthBC);
        Collections.sort(list);
        result = abs(list.get(0) - list.get(2)) *2;


        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        Pointer pointA = new Pointer(Integer.parseInt(token.nextToken()),
                Integer.parseInt(token.nextToken()));
        Pointer pointB = new Pointer(Integer.parseInt(token.nextToken()),
                Integer.parseInt(token.nextToken()));
        Pointer pointC = new Pointer(Integer.parseInt(token.nextToken()),
                Integer.parseInt(token.nextToken()));

        double result = parallelogram(pointA, pointB, pointC);

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}