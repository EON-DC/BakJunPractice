package Programmers;

import java.util.*;
public class P_72412 {
    static HashMap<String, List<Integer>> maps;
    public int[] solution(String[] info, String[] query) {
        maps = new HashMap<String, List<Integer>>();
        int[] answer = new int[query.length];
        for(String in : info){
            String[] data = in.split(" ");
            makeInfo(data, "", 0);
        }
        for(String key : maps.keySet()){
            List<Integer> list = maps.get(key);
            Collections.sort(list);
        }

        int index = 0;
        for(String q : query){
            String temp = q.replaceAll(" and ", "");
            String[] key = temp.split(" ");
            answer[index++] = maps.containsKey(key[0]) ? binarySearch(key[0], Integer.parseInt(key[1])) : 0;
        }

        return answer;
    }

    public static int binarySearch(String key, int score){
        List<Integer> list = maps.get(key);
        int start = 0, end = list.size() -1;

        while(start <= end){
            int avg = (start + end)/ 2;
            if(list.get(avg) < score){
                start = avg + 1;
            }else{
                end = avg -1 ;
            }
        }

        return list.size() - start;
    }

    public static void makeInfo(String[] source, String arranged, int cnt){
        if(cnt == 4){
            int itScore = Integer.parseInt(source[4]);
            if(!maps.containsKey(arranged)){
                List<Integer> list = new ArrayList<Integer>();
                maps.put(arranged, list);
            }
            maps.get(arranged).add(itScore);
            return;
        }
        makeInfo(source, arranged + "-", cnt+1);
        makeInfo(source, arranged + source[cnt], cnt+1);
    }

}