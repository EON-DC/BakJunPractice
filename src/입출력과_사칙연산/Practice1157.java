package 입출력과_사칙연산;

import java.io.*;
import java.util.*;

public class Practice1157 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        target = target.toUpperCase(Locale.ROOT);
        char[] chars = target.toCharArray();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        Map<Character, Integer> map = new HashMap<>();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == next) {
                    count++;
                }
            }
            map.put(next, count);
        }
        Set<Integer> set2 = new HashSet<>(map.values());
        if (map.values().size() != set2.size()) {
            bw.write("?");
        } else {
            Character key = getKey(map, Collections.max(map.values()));
            bw.write(String.valueOf(key));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

}