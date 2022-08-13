package Bronze1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Practice1384 {
    // 1384 문제
    // 학생 이름 리스트를 deque 구조로 구성한다.
    // 받은 맵을 행탐색을 시행하고, N을 만났을 떄, 해당 행의 주인을 찾는다.
    // 몇번째 열인지에 따라 deque를 조작하고 나온 사람이 범인으로
    // 범인 비난했다 행 주인을 작성한다.
    // 탐색이 끝났는데 나쁜말이 없으면 nobody 출력
    // 0을 만나면 프로그램 종료


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag = true;
        int groupConter = 0;
        while (flag) {
            int studentCount = Integer.parseInt(br.readLine());
            groupConter++;
            if (studentCount == 0) {
                break;
            }
            bw.write("Group " + groupConter);
            ArrayList<String> list = new ArrayList<>();
            boolean hasBully = false;
            int[][] papers = new int[studentCount][studentCount - 1]; // 자기 자신은 제외하기 때문
            for (int i = 0; i < studentCount; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                String name = token.nextToken();
                list.add(name);
                for (int j = 0; j < studentCount - 1; j++) {
                    String temp = token.nextToken();
                    if (temp.equals("P")) {
                        papers[i][j] = 1;
                    } else {
                        hasBully = true;
                        papers[i][j] = 0;
                    }
                }
            }
            if (!hasBully) {
                bw.write("\nNobody was nasty");
                continue;
            }
            for (int i = 0; i < studentCount; i++) {
                for (int j = 0; j < studentCount - 1; j++) {
                    if (papers[i][j] == 0) {
                        String aboutName = getNameFromDeq(i, list);
                        String badguy = getNameFromTable(j, list, aboutName);
                        bw.write("\n"+badguy + " was nasty about " + aboutName);
                    }
                }
            }
            bw.write("\n\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String getNameFromTable(int j, ArrayList<String> list, String name) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            deque.add(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            String tempName = deque.poll();
            if (tempName.equals(name)) {
                break;
            } else {
                deque.add(tempName);
            }
        }
        String result = "";
        for (int i = 0; i <= j; i++) {
            result = deque.pollLast();
        }
        return result;

    }

    static String getNameFromDeq(int i, ArrayList<String> list) {
        return list.get(i);
    }
}