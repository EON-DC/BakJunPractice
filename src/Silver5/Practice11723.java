package Silver5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice11723 {


    // 11723번 문제
    // 입력 파라 : 연산의 수, 300만개
    // 둘째줄 : 수행해야하는 연산들
    // switch case 문으로, 정수 세트로 만들기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Set<Integer> mySet = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String order = token.nextToken();
            switch (order) {
                case "add":
                    mySet.add(Integer.parseInt(token.nextToken()));
                    break;
                case "remove":
                    mySet.remove(Integer.parseInt(token.nextToken()));
                    break;
                case "check":
                    int checkNum = Integer.parseInt(token.nextToken());
                    if (mySet.contains(checkNum)) {
                        builder.append("1\n");
                    } else builder.append("0\n");
                    break;
                case "toggle":
                    int toggleNum = Integer.parseInt(token.nextToken());
                    if (mySet.contains(toggleNum)) {
                        mySet.remove(toggleNum);
                    } else mySet.add(toggleNum);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        mySet.add(j);
                    }
                    break;
                case "empty":
                    mySet.clear();
                    break;
            }
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}