package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Practice11724 {


    static int[] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        HashSet<Integer> set = new HashSet<>();
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            if(find(u) != find(v)) union(u, v);
        }
        for (int i = 1; i <= N; i++) {
            set.add(find(map[i]));
        }
        System.out.println(set.size());
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot > bRoot) {
            map[aRoot] = bRoot;
        } else {
            map[bRoot] = aRoot;
        }
    }

    public static int find(int a) {
        if(map[a] == a) return a;
        map[a] = find(map[a]);
        return map[a];
    }
}