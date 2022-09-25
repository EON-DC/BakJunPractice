package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Practice7662 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int lc = Integer.parseInt(br.readLine()); // line count
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (lc-- > 0) {
                String[] line = br.readLine().split(" ");
                String cmd = line[0];
                int input = Integer.parseInt(line[1]);

                if (cmd.equals("I")) {
                    map.put(input, map.getOrDefault(input, 0) + 1);
                }else{
                    int key = -1;
                    if (map.size() == 0) {
                        continue;
                    }
                    if (input == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }

            if (map.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
