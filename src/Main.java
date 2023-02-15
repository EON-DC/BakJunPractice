import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

class Main {
    static String src = "5\n" +
            "4 1 5 2 3\n" +
            "5\n" +
            "1 3 7 9 5";

    static int[] arr;
    static int[] sortedArr;
    static int[] find;
    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        arr = new int[N];
        sortedArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        find = new int[M];
        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : find) {
            if (search(num)) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean search(int num) {
        int hi = N - 1;
        int lo = 0;
        int index = 0;
        while (lo <= hi) {
            int avg = (hi + lo) / 2;
            if (get(avg) > num) {
                hi = avg -1;
            }else if(get(avg) < num){
                lo = avg + 1;
            }else{
                index = avg;
                break;
            }
        }
        if (get(index) != num) {
            return false;
        } else {
            return true;
        }
    }


    static public int get(int index) {
        return arr[index];
    }

}