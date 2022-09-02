package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Practice1043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        boolean[] known_people = new boolean[N + 1];
        parent = new int[N + 1];
        line = br.readLine().split(" ");
        int known_peopleNum = Integer.parseInt(line[0]);
        for (int i = 1; i <= known_peopleNum; i++) {
            int tmp = Integer.parseInt(line[i]);
            known_people[tmp] = true;
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        HashSet<Integer>[] parties = new HashSet[M + 1];
        for (int i = 1; i <= M; i++) {
            parties[i] = new HashSet<>();
        }
        for (int k = 1; k <= M; k++) {
            line = br.readLine().split(" ");
            int partyMemCount = Integer.parseInt(line[0]);
            if (partyMemCount <= 1) {
                parties[k].add(Integer.parseInt(line[1]));
                continue;
            }
            for (int i = 1; i < partyMemCount; i++) {
                int a = Integer.parseInt(line[i]);
                int b = Integer.parseInt(line[i + 1]);
                if (find(a) != find(b)) {
                    union(a, b);
                }
                parties[k].add(a);
                parties[k].add(b);
            }
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (known_people[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= N; j++) {
                    if (find(j) == root) {
                        known_people[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= M; i++) {
            boolean innerBrake = false;
            for (int player : parties[i]) {
                if (known_people[player]) {
                    innerBrake = true;
                    break;
                }
            }
            if (!innerBrake) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }
}
