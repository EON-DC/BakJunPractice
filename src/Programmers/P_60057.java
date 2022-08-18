package Programmers;

public class P_60057 {
    public static void main(String[] args) {
        int result = solution("aabbaccc");
        System.out.println("result = " + result);
    }
    static public int solution(String s) {
        int minLength = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder builder = new StringBuilder();
            int combo = 1;
            String buffer = s.substring(0, i);
            for (int j = i; j < s.length(); j += i) {
                String testUnit = s.substring(j, j + i <= s.length() ? j + i : s.length());
                if (buffer.equals(testUnit)) {
                    combo++;
                } else {
                    if (combo > 1) {
                        builder.append(combo).append(buffer);
                    } else {
                        builder.append(buffer);
                    }
                    combo = 1;
                }
                buffer = testUnit;
            }
            builder.append(combo > 1 ? String.valueOf(combo) + buffer : buffer);
            int tempResult = builder.toString().length();
            minLength = Math.min(minLength, tempResult);
        }
        return minLength;
    }
}

