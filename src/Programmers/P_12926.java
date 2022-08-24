package Programmers;

public class P_12926 {

    public String solution(String s, int n) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            char unit = '1';
            if (c >= 'A' && c <= 'Z') {
                if (c + n - 'A' >= 26) {
                    unit = (char) (c + n - 26);

                } else {
                    unit = (char) (c + n);
                }
            } else if (c >= 'a' && c <= 'z') {
                if (c + n - 'a' >= 26) {
                    unit = (char) (c + n - 26);
                } else {
                    unit = (char) (c + n);
                }
            } else {
                unit = c;
            }
            builder.append(unit);

        }
        return builder.toString();
    }
}