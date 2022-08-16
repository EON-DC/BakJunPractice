package Programmers;

public class P_72410_withRegex {

    public static void main(String[] args) {
        String test = "=.=";
        String result = solution(test);
        System.out.println("result = " + result);
    }

    static public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();
        temp = temp.replaceAll("[^-_.a-z0-9]", "");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}", ".");
        temp = temp.replaceAll("^[.]||[.]$", "");
        System.out.println(temp.length());
        if (temp.equals("")) {
            temp += "a";
        }
        if (temp.length() > 15) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("[.]$", "");
        }
        if (temp.length() <= 2) {
            while (temp.length() < 3) {
                temp += temp.charAt(temp.length() - 1);
            }
        }
        answer = temp;
        return answer;
    }

}