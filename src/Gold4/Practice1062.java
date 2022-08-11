package Gold4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice1062 {

    // 1062번 문제
    // 입력 1줄 : 단어의 개수 N, 읽을 수 있는 글자 K
    // anta - tica  => {a, t, i, c, n}을 배우면 일단 기본적으로 읽을 수 있음
    // 그 외 글자를 알아야 단어 읽기 가능함
    // canReadSet을 만들어 최대 읽을 수 있는 단어의 개수를 찾는다.
    // canReadSet은 임의의 수가 아니라, 제공된 단어 셋에서 추가해야함.
    // 조합을 사용해야함.
    static ArrayList<Character> arrayList = new ArrayList<>();
    static Set<Character> usedCharSet = new HashSet<>();
    static Set<Character> testCharSet = new HashSet<>();
    static boolean[] visited;
    static int maxCount, N, K;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        words = new String[N];
        maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            for (int j = 0; j < words[i].length(); j++) {
                usedCharSet.add(words[i].charAt(j));
            }
        }
        if (K < 5) {
            System.out.println(0);
        } else {
            // 기본적으로 제공되야할 {a, t, i, c, n} 추가
            testCharSet.add('a');
            testCharSet.add('t');
            testCharSet.add('i');
            testCharSet.add('c');
            testCharSet.add('n');

            if (K > 5) {
                usedCharSet.removeAll(testCharSet); // 여기서 K -5개만큼 골라서 testCharSet 넣기
                arrayList.addAll(usedCharSet);
                visited = new boolean[usedCharSet.size()];
                if (usedCharSet.size() < K - 5) {
                    maxCount = N;
                } else {
                    combination(arrayList, visited, 0, usedCharSet.size(), K - 5);

                }
            } else if (K == 5) {
                maxCount = howManyCount(words, testCharSet);
            }

            bw.write(maxCount + "");

            bw.flush();
            bw.close();
            br.close();
        }
    }

    private static int howManyCount(String[] words, Set<Character> usedCharSet) {
        int count = 0;
        for (String temp : words) {
            boolean verify = true;
            for (int j = 0; j < temp.length(); j++) {
                if (!usedCharSet.contains(temp.charAt(j))) {
                    verify = false;
                    break;
                }
            }
            if (verify) {
                count++;
            }
        }
        return count;
    }

    static void combination(ArrayList<Character> list, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < list.size(); i++) {
                if (visited[i]) {
                    char temp = list.get(i);
                    testCharSet.add(temp);
                }
            }
            int tempCount = howManyCount(words, testCharSet);
            maxCount = Math.max(tempCount, maxCount);
            for (int i = 0; i < list.size(); i++) {
                if (visited[i]) {
                    char temp = list.get(i);
                    testCharSet.remove(temp);
                }
            }
            return;
        }
        for (int i = start; i < usedCharSet.size(); i++) {
            visited[i] = true;
            combination(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}