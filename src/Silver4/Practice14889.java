package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Practice14889 {
    static String src = "8\n" +
            "0 5 4 5 4 5 4 5\n" +
            "4 0 5 1 2 3 4 5\n" +
            "9 8 0 1 2 3 1 2\n" +
            "9 9 9 0 9 9 9 9\n" +
            "1 1 1 1 0 1 1 1\n" +
            "8 7 6 5 4 0 3 2\n" +
            "9 1 9 1 9 1 0 9\n" +
            "6 5 4 3 2 1 9 0";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[][] stat;
    static boolean[] visited;
    static int start, link;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(br.readLine());

        stat = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(line[j]);
            }
        }


        // N개중 N/2개를 고르면 start와 link 의 점수 계산 가능.. result에 최솟값 비교하고, 0일 경우 중단
        DFS(0, N / 2);

        System.out.println(result);

    }

    public static void DFS(int index, int residual) {
        if (residual == 0) {

            start = 0;
            link = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        start += stat[i][j];
                        start += stat[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += stat[i][j];
                        link += stat[j][i];
                    }
                }
            }

            int cha = Math.abs(start - link);
            result = Math.min(result, cha);
            return;
        }
        if (result == 0) {
            return;
        }


        for (int i = index; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                DFS(i + 1, residual - 1);
                visited[i] = false;
            }
        }
    }

    public static int getScore(Set<Integer> team) {
        int sum = 0;
        for (int id : team) {
            for (int i = 0; i < N; i++) {
                if (team.contains(i) && i != id) {
                    sum += stat[id][i];
                }
            }
        }
        return sum;
    }
}

