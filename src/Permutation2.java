import java.util.Arrays;

public class Permutation2 {
    public static void main(String[] args) {
        int num = 10;
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20000)-10000;
        }
        System.out.println("Arrays.toString(arr[0]) = " + Arrays.toString(arr));

        int[] output = new int[num];
        boolean[] visited = new boolean[num];

        perm(arr, output, visited, 0, num, 2);

    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int num, int r) {
        if (depth == r) {
            print(output, r);
        }

        for (int i = 0; i < num; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, num, r);
                visited[i] = false;

            }
        }

    }

    public static void print(int[] arr, int r) {

        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + "");
            if (i < r - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
