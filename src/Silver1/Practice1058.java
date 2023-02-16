package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Practice1058 {

    static String src = "15\n" +
            "NNNNNNNNNNNNNNY\n" +
            "NNNNNNNNNNNNNNN\n" +
            "NNNNNNNYNNNNNNN\n" +
            "NNNNNNNYNNNNNNY\n" +
            "NNNNNNNNNNNNNNY\n" +
            "NNNNNNNNYNNNNNN\n" +
            "NNNNNNNNNNNNNNN\n" +
            "NNYYNNNNNNNNNNN\n" +
            "NNNNNYNNNNNYNNN\n" +
            "NNNNNNNNNNNNNNY\n" +
            "NNNNNNNNNNNNNNN\n" +
            "NNNNNNNNYNNNNNN\n" +
            "NNNNNNNNNNNNNNN\n" +
            "NNNNNNNNNNNNNNN\n" +
            "YNNYYNNNNYNNNNN";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int result;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            BFS(i, i, 2);
        }

        System.out.println(result);

    }

    static public void BFS(int index, int friendIndex, int depth) {
        // 2번째까지만 친구임. 재귀보단, bfs + node 구성이 나아보임
        // queue 를 형성, depth =1 친구들 추가, depth 0 될 때까지 visited 추가
        // visited 참값 개수 세기

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(friendIndex, depth));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.depth == 0) {
                continue;
            }
            for (int i = 0; i < N; i++) {
                if (map[i][poll.friendIndex] == 'Y' && visited[i] == false) {
                    visited[i] = true;
                    queue.add(new Node(i, poll.depth - 1));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == true && i != index) {
                count++;
            }
        }
        result = Math.max(result, count);
    }

    static class Node {
        int friendIndex;
        int depth;

        public Node(int friendIndex, int depth) {
            this.friendIndex = friendIndex;
            this.depth = depth;
        }
    }
}

