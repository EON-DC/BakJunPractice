package Bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice1032 {


    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeatTime = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < repeatTime; i++) {
            list.add(br.readLine());
        }
        if (repeatTime == 1) {
            System.out.println(list.get(0));
        } else {


            int textLength = list.get(0).length();
            boolean validation = false;
//        System.out.println("list.get(0) = " + list.get(0));
//        System.out.println("String.valueOf(list.get(0).charAt(0)) = " + String.valueOf(list.get(0).charAt(0)));
//        System.out.println("validation = " + String.valueOf(list.get(0).charAt(0)).equals(String.valueOf(list.get(1).charAt(0))));
            boolean[] arr = new boolean[textLength];
            for (int i = 0; i < textLength; i++) {
                arr[i] = false;
                Set<Boolean> set = new HashSet<>();
                for (int a = 0; a < repeatTime; a++) {
                    for (int b = 0; b < repeatTime; b++) {
                        if (a == b) {
                            continue;
                        } else {
                            boolean check = false;
                            check = String.valueOf(list.get(a).charAt(i)).equals(String.valueOf(list.get(b).charAt(i)));
                            set.add(check);
                        }
                    }
                }
                if (set.size() == 1 && set.contains(true)) {
                    System.out.print(list.get(0).charAt(i));
                } else {
                    System.out.print("?");
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {
        new Practice1032().solution();
    }
}

