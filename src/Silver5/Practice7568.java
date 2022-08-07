package Silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Practice7568 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 덩치 문제
        // 몸무게, 키를 입력 받는다 (몸무게, 키는 각각 10~200)
        // 사람은 2~50명
        // 키와 몸무게를 클래스로 받고, comparable
        int testCycle = Integer.parseInt(br.readLine());
        StringTokenizer token;
        ArrayList<Body> bodies = new ArrayList<>();
        for (int i = 0; i < testCycle; i++) {
            token = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            Body body = new Body(weight, height, i);
            bodies.add(body);
        }

        // 인자를 지나갈 때, compare써서 결과값이 뜨면, 랭크 카운트 증가

        for (int i = 0; i < bodies.size() ; i++) {
            int rank = 1;
            for (int j = 0; j < bodies.size(); j++) {
                if (i == j) continue;
                if (bodies.get(i).compareTo(bodies.get(j))> 0) {
                    rank++;
                }
            }
            Body temp = bodies.get(i);
            temp.rank = rank;
        }

        bodies.sort(new Comparator<Body>() {
            @Override
            public int compare(Body o1, Body o2) {
                if (o1.id > o2.id) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < bodies.size(); i++) {
            bw.write(bodies.get(i).rank+ " ");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    static class Body implements Comparable<Body> {
        int id;
        int height;
        int weight;
        int rank = 0;


        public Body(int weight, int height, int id) {
            this.weight = weight;
            this.height = height;
            this.id = id;
        }

        @Override
        public int compareTo(Body o) {
            if (this.height < o.height && this.weight < o.weight) {
                return 1;
            }
            return 0;
        }

    }
}
