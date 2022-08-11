package Silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// fail
// 그리디로 풀어야할 문제인데, BFS 로 접근하여 queue만 add하고 답이 도출이 안됨
// 추후 반성용, 기억 참고용으로 save
public class Practice11047_fail {

    static int N, K;

    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> coins = new ArrayList<>();

    static int ans = Integer.MAX_VALUE;
    // index : 코인 개수 누적,  value : sum의 금액

    public static void bfs(int depth, int sum) {
        queue.add(new int[]{depth, sum});
        while (!queue.isEmpty()) {
            int temDepth = queue.peek()[0];
            int temSum = queue.peek()[1];
            queue.poll();
            for (int i = coins.size() - 1; i > 0; i--) {
                int newSum = coins.get(i) + temSum;
                if (newSum < K) {
                    queue.add(new int[]{temDepth + 1, temSum + coins.get(i)});
                } else if (newSum == K) {
                    int result = temDepth + 1;
                    ans = result;
                    return;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K) {
                coins.add(coin);
            }
        }


        bfs(0, 0);
        bw.write(ans + "");


        bw.flush();
        bw.close();
        br.close();
    }


}

