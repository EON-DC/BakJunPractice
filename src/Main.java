import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
//    static String src = "";
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new StringReader(src));

        /**
         * cap	n	deliveries	pickups	result
         * 4	5	[1, 0, 3, 1, 2]	[0, 3, 0, 4, 0]	16
         * 2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
         */
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        long result = solution(cap, n, deliveries, pickups);
        System.out.println("result = " + result);
    }

    public static boolean isFinished(Integer[] arr){
        for(int n : arr){
            if(n > 0) return false;
        }
        return true;
    }
    public static int doing(Integer[] arr, int cap, int n){
        int distance = 0;
        int truck = cap;

        long x = 10;

        for(int i = n-1 ; i >=0 ; i--){
            if(arr[i] == 0) continue;
            if(arr[i] > truck) {
                arr[i] -= truck;
                truck = 0;
            }else if(arr[i] == truck){
                arr[i] = 0;
                truck = 0;
            }else{
                truck -= arr[i];
                arr[i] = 0;
            }

            if(distance == 0) distance = i+1;
            if(truck == 0) break;
        }
        return distance;
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long distance = 0;
        Integer[] del = new Integer[n];
        Integer[] pic = new Integer[n];
        for(int i = 0; i< n; i++){
            del[i] = deliveries[i];
            pic[i] = pickups[i];
        }

        Outer:
        while(!isFinished(del) && !isFinished(pic)){

            distance += Math.max(doing(del, cap, n), doing(pic, cap, n)) * 2L;
            System.out.println(distance);

        }

        return distance;}
}