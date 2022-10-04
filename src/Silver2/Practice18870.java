package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Practice18870 {


    static int[] list;
    static int[] copyList;
    static Map<Integer, Integer> maps = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pn = Integer.parseInt(br.readLine()); // point number
        String[] line = br.readLine().split(" ");
        list = new int[1000001];
        for (int i = 0; i < line.length; i++) {
            list[i] = Integer.parseInt(line[i]);
        }
        copyList = Arrays.copyOfRange(list, 0, pn);
        Arrays.sort(copyList);
        StringBuilder sb = new StringBuilder();
        int sequence = 0;
        for (int i = 0; i < pn; i++) {
            if (!maps.containsKey(copyList[i])) {
                maps.put(copyList[i], sequence++);
            }
        }
        for (int i = 0; i < pn; i++) {
            sb.append(maps.get(list[i]) + " ");
        }
        System.out.println(sb);

    }

    /**
     * 좌표를 배열에 저장하고, 따로 컬렉션에 저장,
     * 저장된 컬렉션에서 찾아 복사, 복사된 컬렌션은 오름정렬 후 인덱스를 반환
     * 조회 알고 bigO(N) -> 같은 수라면 매번 조회보단, 메모리얼을 해놓는게 좋을 듯
     */

}