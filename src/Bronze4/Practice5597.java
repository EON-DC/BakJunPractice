package Bronze4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice5597 {


    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 1; i <= 30; i++) {
            if (list.contains(i) != true) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Practice5597().solution();
    }
}

