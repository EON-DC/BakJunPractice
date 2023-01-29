import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    static String src = "123 456";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Set<Integer> primeSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new StringReader(src));

        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        int cnt = 0;

        findPrime(b);

        for (int i = a; i <= b; i++) {
            if (isUnderPrime(i)) {
                cnt++;
                System.out.println(i);
            }

        }
        System.out.println(cnt);

    }

    public static boolean isUnderPrime(int num) {
        List<Integer> primeList = new ArrayList<>();

        for()


        if (primeSet.contains(primeList.size())) {
            System.out.println("num : " + num + ", size : " + primeList.size());
            System.out.println(primeList);
            return true;
        }
        return false;
    }

    public static void findPrime(int num) {
        int k = 2;
        int sqrtNum = (int) Math.ceil(Math.sqrt(num));
        while (k <= sqrtNum && num != 1) {
            if (num % k == 0) {
                num /= k;
                if (!primeSet.contains(k)) {
                    primeSet.add(k);
                }
            } else {
                k++;
            }
        }
        if (num != 1) {
            if (!primeSet.contains(k)) {
                primeSet.add(num);
            }
        }
    }
}