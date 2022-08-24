package Programmers;

import java.util.*;
public class P_42839 {
    public int solution(String numbers) {
        int answer = 0;

        String[] chars = numbers.split("");
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= chars.length ; i++){
            boolean[] visited = new boolean[chars.length];
            ArrayList<String> buffer = new ArrayList<>();
            combination(chars, visited, buffer, chars.length, i, set);
        }

        return set.size();
    }

    static public boolean isPrime(int n){  // 소수인지 판별
        if(n == 1 || n == 0){
            return false;
        }

        for(int i = 2 ; i<= (int)Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static public void combination(String[] chars, boolean[] visited, ArrayList<String> buffer, int N, int r, HashSet<Integer> set){
        if(r == 0){
            StringBuilder builder = new StringBuilder();
            for(String a : buffer){
                builder.append(a);
            }
            int tempResult = Integer.parseInt(builder.toString());
            if(isPrime(tempResult)){
                set.add(tempResult);
            }
            return;
        }

        for(int i = 0 ; i< N ; i++){
            if(!visited[i]){
                visited[i] = true;
                buffer.add(chars[i]);
                combination(chars, visited, buffer, N, r-1, set);
                buffer.remove(buffer.size()-1);
                visited[i] = false;
            }
        }

    }
}
