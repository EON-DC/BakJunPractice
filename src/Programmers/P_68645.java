package Programmers;

import java.util.*;
public class P_68645 {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            int[] temp = new int[i];
            Arrays.fill(temp, 0);
            list.add(temp);
        }
        //마지막 index 는? 1~n까지의 합 -> n(n+1)/2
        int len = n;
        int depth = 0;
        int start = 1;
        while(len != 0){
            switch(depth%3){
                case 0:
                    for(int i = 0; i< len; i++){
                        //System.out.println(depth%3 + " : "+ start);
                        addFirst(list.get(i+2*(depth/3)), start++);
                    }
                    break;
                case 1:
                    for(int i = 0; i< len ; i++){
                        //System.out.println(depth%3 + " : "+ start);
                        //System.out.println("len-(depth/3) : " + (len-(depth/3)));
                        addFirst(list.get(n-(depth/3)-1),start++);
                    }
                    break;
                case 2:
                    for(int i = 0 ; i < len ; i++){
                        //System.out.println(depth%3 + " : "+ start);
                        addBack(list.get(n-(depth/3)-2-i), start++);
                    }
                    break;
            }
            len--;
            depth++;
        }


        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< n; i++){
            int[] temp = list.get(i);
            for(int j : temp){
                result.add(j);
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void addFirst(int[] arr, int k){
        for(int i = 0 ; i< arr.length ; i++){
            if(arr[i] == 0){
                arr[i] = k;
                return;
            }
        }
    }

    public static void addBack(int[] arr, int k){
        for(int i = arr.length-1 ; i>= 0  ; i--){
            if(arr[i] == 0){
                arr[i] = k;
                return;
            }
        }
    }

}