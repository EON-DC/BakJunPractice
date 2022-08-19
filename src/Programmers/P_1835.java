package Programmers;

import java.util.ArrayList;

public class P_1835 {

    public int solution(int n, String[] data) {
        int answer = 0;
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        boolean[] visited = new boolean[8];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Character> tool = new ArrayList<>();
        permutation(friends, 8, 8, visited, list, tool);
        String[] arrlist = list.toArray(new String[0]);
        int removedCount = 0;
        // list 에 8개의 프렌즈로 구성할 수 있는 문자열은 다 만듦
        for (int i = 0; i < data.length; i++) {
            char s1 = data[i].charAt(0);
            char s2 = data[i].charAt(2);
            char order = data[i].charAt(3);
            int indexLength = data[i].charAt(4) - '0' + 1;
            for (int j = 0; j < arrlist.length; j++) {
                if (!arrlist[j].equals("")) {
                    String temp = arrlist[j];
                    int abs = Math.abs(temp.indexOf(s1) - temp.indexOf(s2));
                    switch (order) {
                        case '=':
                            if (abs != indexLength) {
                                arrlist[j] = "";
                                removedCount++;
                            }
                            break;
                        case '>':
                            if (abs <= indexLength) {
                                arrlist[j] = "";
                                removedCount++;
                            }
                            break;
                        case '<':
                            if (abs >= indexLength) {
                                arrlist[j] = "";
                                removedCount++;
                            }
                            break;
                    }
                }
            }
        }
        answer = arrlist.length - removedCount;
        return answer;
    }


    public static void permutation(char[] friends, int r, int N,
                                   boolean[] visited, ArrayList<String> list, ArrayList<Character> tool) {
        if (r == 0) {
            StringBuilder builder = new StringBuilder();
            for (char c : tool) {
                builder.append(c);
            }
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tool.add(friends[i]);
                permutation(friends, r - 1, N, visited, list, tool);
                tool.remove(tool.size() - 1);
                visited[i] = false;
            }
        }
    }
}
