public class Permutation2 {
    public static void main(String[] args) {
        int num = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[num];
        boolean[] visited = new boolean[num];

        perm(arr, output, visited, 0, num, 3);

    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int num, int r) {
        if (depth == r) {
            print(output, r);
        }

        for (int i = 0; i < r; i++) {
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
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
