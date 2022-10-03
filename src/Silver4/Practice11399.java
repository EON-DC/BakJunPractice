package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Practice11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pn = Integer.parseInt(br.readLine()); // peaple number
        String[] line = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            list.add(Integer.parseInt(line[i]));
        }
        Collections.sort(list);
        int result = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            index += list.get(i);
            result += index;
        }
        System.out.println(result);
    }

}
