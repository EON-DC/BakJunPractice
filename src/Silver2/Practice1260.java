package Silver2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1260 {
    static int N, M, V, count;
    static int map[][];
    static boolean visited[];

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        System.out.print(V + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        if (V == map.length) {
            return;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        V = Integer.parseInt(tokenizer.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(tokenizer.nextToken());
            int N2 = Integer.parseInt(tokenizer.nextToken());
            map[N1][N2] = 1;
            map[N2][N1] = 1;
        }
        visited = new boolean[N + 1]; // 정점의 개수만큼만
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1]; // 정점의 개수만큼만
        bfs(V);
    }
}