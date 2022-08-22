package Programmers;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class P_17677 {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 자카드 유사도를 계산한 뒤 66536을 곱한 후, 소수점 버리고 정수부 출력
        // 2자씩 끊어 행렬을 만들어주는 함수
        // 이들의 합집합, 교집합을 계산하는 함수
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> str1List = new ArrayList<>();
        ArrayList<String> str2List = new ArrayList<>();
        System.out.println("maked str1:");
        makeArr(str1, str1List);
        System.out.println("maked str2:");
        makeArr(str2, str2List);
        int kyoCount = 0;
        ArrayList<String> habList = new ArrayList<>();
        for (String s : str1List) {
            if (str2List.contains(s)) {
                str2List.remove(s);
                habList.add(s);
                kyoCount++;
            } else {
                habList.add(s);
            }
        }
        for (String s2 : str2List) {
            habList.add(s2);
        }
        int habCount = habList.size();
        System.out.println("habList.size() : " + habList.size());
        if (habCount == 0) {
            return 65536;
        }

        answer = (int) Math.floor(((double) kyoCount / habCount) * 65536);

        return answer;
    }

    static public void makeArr(String str, ArrayList<String> strList) {
        for (int i = 0; i < str.length() - 1; i++) {
            String testUnit = str.substring(i, i + 2);
            boolean verify = Pattern.matches("^[A-Z]*$", testUnit);
            if (verify) {
                strList.add(testUnit);
                System.out.println(testUnit);
            }
        }
    }
}
