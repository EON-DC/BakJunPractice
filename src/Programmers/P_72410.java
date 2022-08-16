package Programmers;

public class P_72410 {

    public static void main(String[] args) {
        String test = "=.=";
        String result = solution(test);
        System.out.println("result = " + result);
    }

    static public String solution(String new_id) {
        String answer = new_id;

        answer = answer.toLowerCase();

        String enableCase = "abcdefghijklmnopqrstuvwxyz0123456789-_.";
        char[] chars = enableCase.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < answer.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == answer.charAt(i)) {
                    builder.append(answer.charAt(i));
                }
            }
        }
        answer = builder.toString();
        builder = new StringBuilder();
        char buffer = '*';
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '.' && buffer == answer.charAt(i)) {
                buffer = answer.charAt(i);
                continue;
            } else {
                buffer = answer.charAt(i);
                builder.append(answer.charAt(i));
            }
        }
        answer = builder.toString();
        while (true) {
            if (answer.length() == 0 || answer.charAt(0) != '.') {
                break;
            }
            answer = answer.substring(1);
        }

        while (true) {
            if (answer.length() == 0 || answer.charAt(answer.length() - 1) != '.') {
                break;
            }
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.equals("")) {
            answer += "a";
        }

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            while (true) {
                if (answer.charAt(answer.length() - 1) != '.') {
                    break;
                }
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        while (true) {
            if (answer.length() > 2) {
                break;
            }
            answer += String.valueOf(answer.charAt(answer.length() - 1));
        }
        return answer;
    }
}