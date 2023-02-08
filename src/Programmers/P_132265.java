package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_132265 {
    public int solution(int[] topping) {
        Map<Integer, Integer> store = new HashMap<>();
        // topping , count
        for(int top :topping){
            if(store.get(top) == null){
                store.put(top, 0);
            }
            int num = store.get(top);
            store.put(top, num+1);
        }
        int size = store.size();

        int result = 0;
        Set<Integer> pre = new HashSet<>();
        for(int i = 0; i< topping.length ; i++){
            pre.add(topping[i]);
            store.put(topping[i], store.get(topping[i])-1);
            if(store.get(topping[i]) == 0) {
                store.remove(topping[i]);
            }
            if(store.size() == pre.size()){
                result++;
            }
        }
        return result;
    }
}
