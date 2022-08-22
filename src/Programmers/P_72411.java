package Programmers;
import java.util.*;

public class P_72411 {
    static int maxUsedCount = 0;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Set<Character> usedSet = new HashSet<>();
        for(String order : orders){
            for(int i = 0; i< order.length() ; i++){
                usedSet.add(order.charAt(i));
            }
        }

        ArrayList<Character> alphaList = new ArrayList<>();
        alphaList.addAll(usedSet);
        ArrayList<String> resultList = new ArrayList<>();
        for(int i :  course){
            boolean[] visited = new boolean[alphaList.size()];
            HashMap<String, Integer> maps = new HashMap<>();
            combination(alphaList, visited, 0, alphaList.size(), i, maps, orders);
            for(Map.Entry<String, Integer> entry : maps.entrySet()){
                if(entry.getValue() == maxUsedCount && maxUsedCount >= 2) {
                    resultList.add(entry.getKey());
                }
            }
            maxUsedCount = 0;
        }
        Collections.sort(resultList);
        answer = resultList.stream().map(String::valueOf).toArray(String[]::new);

        return answer;
    }

    static public void combination(ArrayList<Character> alphaList, boolean[] visited,
                                   int start, int N, int residual, HashMap<String, Integer> maps, String[] orders){
        if(residual == 0){
            // pick 끝
            String s = "";
            for(int i = 0 ; i< N ; i++){
                if(visited[i]){
                    s += (alphaList.get(i));
                }
            }
            String[] arr = s.split("");
            int usingCount = 0;
            Outer:
            for(String order : orders){
                if(order.length() < s.length()){
                    continue Outer;
                }
                boolean verify = true;
                for(int i = 0 ; i< s.length() ; i++){
                    verify = verify && order.contains(arr[i]);
                    if(!verify){
                        continue Outer;
                    }
                }
                if(verify){
                    usingCount++;
                }
            }
            if(maxUsedCount <= usingCount){
                maps.put(s, usingCount);
                maxUsedCount = Math.max(maxUsedCount, usingCount);
            }
            return;
        }
        for(int i = start ; i< N ; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(alphaList, visited, i+1,N, residual-1, maps, orders);
                visited[i] = false;
            }
        }

    }
}