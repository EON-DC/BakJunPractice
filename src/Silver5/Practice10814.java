package Silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Practice10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int memberNum = Integer.parseInt(br.readLine());
        StringTokenizer token;
        Member[] Members = new Member[memberNum];
        for (int i = 0; i < memberNum; i++) {
            token = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(token.nextToken());
            String name = token.nextToken();
            Members[i] = new Member(age, name, i);
        }

        Arrays.sort(Members, (o1, o2) -> {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age == o2.age) {
                if (o1.index > o2.index) {
                    return 1;
                } else return -1;
            } else return -1;
        });

        for (Member member : Members) {
            bw.write(member.toString());
        }
        bw.flush();
        bw.close();
        br.close();


    }

    static class Member {

        int age;
        String name;
        int index;

        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return age +
                    " " + name + '\n';
        }
    }
}
