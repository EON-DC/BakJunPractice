package Bronze1;

import java.io.*;

public class Practice10989 {

    // Collection Sort 는 메모리 초과로 시행되지 않음.
    // 512MB  메모리로 counting sort 사용 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int inputLine = Integer.parseInt(br.readLine());
        int[] count = new int[10000000 + 1]; // 자연수 1부터 시작하기 때문
        for (int i = 0; i < inputLine; i++) {
            count[Integer.parseInt(br.readLine())]++;
            // 0으로 초기화되어있는 배열에 개수를 증가시킴으로써
            // 추후 나열할 때 반복횟수로 사용한다.
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            } else {
                int time = count[i];
                for (int j = 0; j < time; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

