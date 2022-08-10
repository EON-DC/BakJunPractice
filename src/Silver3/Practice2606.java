package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice2606 {


    static int map[][];
    static int visited[];
    static int p;// pointCount
    static int l; // lineCount
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = Integer.parseInt(br.readLine());
        l = Integer.parseInt(br.readLine());
        StringTokenizer token;

        map = new int[p + 1][p + 1];
        visited = new int[p + 1];

        for (int i = 0; i < p + 1; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < l; i++) {
            token = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(token.nextToken());
            int p2 = Integer.parseInt(token.nextToken());
            map[p1][p2] = 1;
            map[p2][p1] = 1;
        }
        count = -1;
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int n) {
        visited[n] = 1;
        count++;
        for (int i = 0; i <= p; i++) {
            if (map[n][i] == 1 && visited[i] == -1) {
                dfs(i);
            }
        }
    }
}

