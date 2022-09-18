import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws IOException{
        test();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        while (true) {
            String unit = br.readLine();
            if (unit == null) {
                break;
            }
            s.append(unit);
        }

        System.out.println(solution(s.toString()));
    }


    public static int solution(String s) {
        String[] lines = s.split("\n");
        int N = Integer.parseInt(lines[0]);

    }

    public static boolean test() {
        int result;
        result = solution("3\n" +
                "6 8 9\n" +
                "5\n" +
                "2 5 2 4 7");
        if (result != 2) {
            return false;
        }
        result = solution("2\n" +
                "19 20\n" +
                "7\n" +
                "14 12 16 19 16 1 5");
        if (result != 4) {
            return false;
        }
        result = solution("4\n" +
                "23 32 25 28\n" +
                "10\n" +
                "5 27 10 16 24 20 2 32 18 7");
        if (result != 3) {
            return false;
        }

        result = solution("10\n" +
                "11 17 5 2 20 7 5 5 20 7\n" +
                "5\n" +
                "18 18 15 15 17");
        if (result != 2) {
            return false;
        }

        return true;
    }
}