package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Practice2667 {

    // main에서 전체탐색을 시키고 find 마다 count
    // dfs 는 해당 인접 visit 처리

    static int map[][];
    static boolean visited[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N, count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx < N && cy < N && cx >= 0 && cy >= 0) {
                if (map[cx][cy] == 1 && !visited[cx][cy]) {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                }
                return -1;
            }
        });
        System.out.println(list.size());
        for (int ele : list) {
            System.out.println(ele);
        }

    }

}
