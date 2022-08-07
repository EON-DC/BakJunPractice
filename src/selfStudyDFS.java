import java.util.Arrays;
import java.util.Stack;

public class selfStudyDFS {
    public static void main(String[] args) {
        int input = 10;
        System.out.println("fibo(input) = " + String.valueOf(fibo(input)));
        System.out.println("fibo(input) = " + String.valueOf(stackFibo(input)));

        String line = "abcde";
        char[] chars = line.toCharArray();
        System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
        String s = "";

        for (int i = 0; i < chars.length; i++) {
            s.concat(String.valueOf(chars[i]));
        }

    }

    // 피보나치 수열의 재귀 구현
    private static int fibo(int input) {
        if (input == 1) {
            return 1;
        } else if (input > 1) {
            return input * fibo(input - 1);
        }
        return 0;
    }

    // 피보나치 수열의 스택 구현

    private static int stackFibo(int input) {
        Stack<Integer> stack = new Stack<>();
        stack.add(input);
        int result = 1;
        int guide = input; //
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            result *= temp;
            if (guide > 1) {
                stack.add(--guide);
            }
        }
        return result;
    }


}
