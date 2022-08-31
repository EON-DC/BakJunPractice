package Silver4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Practice1205 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int score = scanner.nextInt();
        int P = scanner.nextInt();  //랭킹 리스트에 오를 수 있는 갯수.

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        if(N == P && score <= arr[arr.length-1])
            System.out.print(-1);
        else{
            int rank = 1;
            for(int i=0; i<arr.length; i++){
                if(score < arr[i])
                    rank++;
                else
                    break;
            }
            System.out.print(rank);
        }
    }
}