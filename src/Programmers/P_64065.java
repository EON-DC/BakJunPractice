package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P_64065 {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for (String a : arr) {
            String[] unit = a.split(",");
            for (String unitString : unit) {
                int test = Integer.parseInt(unitString);
                if (!list.contains(new Integer(test))) {
                    list.add(test);
                }
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
