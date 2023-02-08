package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Practice1124 {
    static String src = "2 100000";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a, b;

    static boolean[] notPrimeSet = new boolean[10001];
    static Set<Integer> primeSet = new HashSet<>();


    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));
        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        setUp();

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isUnderPrime(i)) {
                count++;
            }
        }

        System.out.println(count);

    }

    static public void setUp() {
        notPrimeSet[0] = true;
        notPrimeSet[1] = true;
        for (int i = 2; i <= 10000; i++) {
            int num = i;
            if (notPrimeSet[num] == false) {
                for (int j = num + num; j <= 10000; j += num) {
                    notPrimeSet[j] = true;
                }
            }
        }

        for (int i = 2; i <= 10000; i++) {
            if (notPrimeSet[i] == false) {
                primeSet.add(i);
            }
        }

    }

    static public boolean isUnderPrime(int num) {
        int count = 0;
        for (int prime : primeSet) {
            while (num % prime == 0) {
                num /= prime;
                count++;
            }
        }
        if (num != 1) {
            count++;
        }
        if (primeSet.contains(count)) {
            return true;
        }
        return false;

    }

}

