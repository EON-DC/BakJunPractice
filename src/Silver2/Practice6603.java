package Silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice6603 {


    static ArrayList<String> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(token.nextToken());
            if (order == 0) {
                list.remove(list.size() - 1);
                break;
            }
            int[] group = new int[order];
            boolean[] visited = new boolean[order];
            for (int i = 0; i < order; i++) {
                group[i] = Integer.parseInt(token.nextToken());
            }
            combination(group, visited, 0, order, 6);
            list.add("\n");
        }
        for (String s : list) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            addArrayResult(arr, visited, n);
            return;
        }

        for (int i = start; i <n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void addArrayResult(int[] arr, boolean[] visited, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                builder.append(arr[i] + " ");
            }
        }
        builder.append("\n");
        list.add(builder.toString());
    }
}