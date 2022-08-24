package Programmers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class P_42746 {
    public String solution(int[] numbers) {
        String answer = "";
        //sorting후
        String[] Snumbers = new String[numbers.length];
        int index = 0;
        for (int i : numbers) {
            Snumbers[index++] = String.valueOf(i);
        }
        Arrays.sort(Snumbers, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        for (String s : Snumbers) {
            answer += String.valueOf(s);
        }
        // 앞자리 0 가능성으로 BigInteger 한번 변환
        BigInteger temp = new BigInteger(answer);

        return String.valueOf(temp);
    }
}
