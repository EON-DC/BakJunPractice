package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practice9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCycle = Integer.parseInt(br.readLine());
        Outer:
        while (testCycle-- > 0) {
            int clothCnt = Integer.parseInt(br.readLine());
            Map<String, Integer> maps = new HashMap<>();
            for (int i = 0; i < clothCnt; i++) {
                String[] line = br.readLine().split(" ");
                String cloth = line[0];
                String sub_category = line[1];
                if (!maps.containsKey(sub_category)) {
                    maps.put(sub_category, 0);
                }
                maps.put(sub_category, maps.get(sub_category) +1);
            }
            boolean flag = false;
            if (maps.keySet().size() == 1) {
                flag = true;
            }
            ArrayList<Integer> cate_cnt = new ArrayList<>();
            int result = 1;
            for (String key : maps.keySet()) {
                if (flag) {
                    System.out.println(maps.get(key).intValue());
                    continue Outer;
                }
                result *= maps.get(key)+1;
            }
            System.out.println(result-1);
        }
    }
}
