package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Practice1697 {
    static int visited[];


    public static void main(String[] args) throws IOException {
        testMain();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int result = solution(N, K);

        System.out.println(result);

    }

    private static int solution(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[100001];
        queue.add(N);
        int index = N;
        visited[index] = 1;
        int n = 0;
        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n == K) {
                break;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (n * 2 <= 100000 && visited[n * 2] == 0) {
                visited[n * 2] = visited[n] + 1;
                queue.add(n * 2);
            }
        }
        return visited[n]-1;
    }

    public static void testMain() {
        if (solution(5, 17) != 4) {
            System.out.println("false");
        }
        if (solution(1, 3) != 2) {
            System.out.println("false");
        }
        if (solution(5, 18) != 3) {
            System.out.println("false");
        }
        if (solution(15, 13) != 2) {
            System.out.println("15 13 false");
        }
        if (solution(5, 0) != 5) {
            System.out.println("5 0 false");
        }
        if (solution(2, 4) != 1) {
            System.out.println("2 4 false");
        }
        if (solution(4, 10) != 2) {
            System.out.println("4 10 false");
        }
        if (solution(50, 98) != 2) {
            System.out.println("50 98 false");
        }

        System.out.println("test clear");
    }
}
