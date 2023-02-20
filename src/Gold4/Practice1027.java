package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Practice1027 {

    static String src = "15\n" +
            "1 5 3 2 6 3 2 6 4 2 5 7 3 1 5";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] buildings;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(br.readLine());
        buildings = new long[N + 1];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            buildings[i + 1] = Integer.parseInt(data[i]);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int count = search(i, 1) + search(i, -1);
            result = Math.max(result, count);
        }

        System.out.println(result);

    }

    public static int search(int index, int direction) {
        if ((index == 1 && direction == -1) || (index == N && direction == 1)) {
            return 0;
        }

        int nextPoint = index + direction;
        long gradientX = nextPoint - index;
        long gradientY = buildings[nextPoint] - buildings[index];

        int distance = 1;
        while (true) {
            nextPoint += direction;
            if (nextPoint >= 1 && nextPoint <= N) {
                long nextGradientX = nextPoint - index;
                long nextGradientY = buildings[nextPoint] - buildings[index];
                if (isPossible(gradientX, gradientY, nextGradientX, nextGradientY, direction)) {
                    gradientX = nextGradientX;
                    gradientY = nextGradientY;
                    distance++;
                }
            } else {
                break;
            }
        }
        return distance;

    }

    public static boolean isPossible(long gradientX, long gradientY, long nextGradientX, long nextGradientY, int direction) {
        if (direction > 0) {
            // grY / grX < nexGrY / nexGrX
            if (nextGradientX * gradientY < nextGradientY * gradientX) {
                return true;
            } else {
                return false;
            }
        } else {
            return nextGradientX * gradientY > nextGradientY * gradientX;
        }

    }

}
