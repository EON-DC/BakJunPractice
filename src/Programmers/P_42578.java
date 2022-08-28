package Programmers;

import java.util.*;
public class P_42578 {
    public int solution(String[][] clothes) {
        Set<String> typeSet = new HashSet<>();
        ArrayList<Cloth> list = new ArrayList<>();
        for(String[] cloth : clothes){
            String name = cloth[0];
            String type = cloth[1];
            typeSet.add(type);
            list.add(new Cloth(name, type));
        }
        Iterator iterator = typeSet.iterator();
        int[] variable = new int[typeSet.size()];
        int index = 0;
        while(iterator.hasNext()){
            int count = 0;
            String unitType = (String) iterator.next();
            for(Cloth cloth : list){
                if(cloth.type.equals(unitType)){
                    count++;
                }
            }
            variable[index++] = count+1;
        }
        int sum = 1;
        for(int i : variable){
            sum *= i;
        }
        sum--;

        return sum;
    }

    // 경우의 수 문제
    // 서로 다른 종류의 아이템을 넣고 안 넣고에 따라 만들 수 있는 경우의 수, 최소 한 개의 의상을 입어야함
    // 만들 수 있는 경우의 수는 {카테고리+1(안입는 경우)} * {카테고리+1(안입는 경우)} * ...  - 1(모든걸 안입는 경우)
    // 카테고리 별로 수를 세야함,

    class Cloth{
        String name;
        String type;
        Cloth(String name, String type){
            this.name = name;
            this.type = type;
        }
    }
}
