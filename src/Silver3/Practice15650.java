package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice15650 {
    static int[] enable;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        enable = new int[m];
        dfs(1, 0);

        System.out.println(sb);


    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int num : enable) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= n; i++) {
            enable[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

}