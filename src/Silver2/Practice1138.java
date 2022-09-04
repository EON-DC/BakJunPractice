package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Practice1138 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        String[] line = br.readLine().split(" ");
        for (int i = N-1; i >= 0; i--) {
            int itsHeight = i + 1;
            int upperNum = Integer.parseInt(line[i]);

            list.add(upperNum, itsHeight);

        }

        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}

