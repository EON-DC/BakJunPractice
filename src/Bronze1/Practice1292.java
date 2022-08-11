package Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1292 {

    // 1292번
    // start, end 받아놓고
    //
    // start가 몇번째 자연수a에 속하는지 찾기
    // end가 몇번째 자연수b에 속하는지 찾아서 그 이전 다 빼기

    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());
        int startsum = 0;
        int endsum = 0;
        int startBlock = 0;
        int endBlock = 0;
        boolean flag = true;
        start--;
        end--;
        while (flag) {
            startBlock++;
            int lastestBlockCountSum = ((startBlock) * (startBlock) + (startBlock)) / 2;
            if ( lastestBlockCountSum > start) {
                int resiCount = start - ((startBlock - 1) * (startBlock - 1) + (startBlock - 1)) / 2;
                startsum = resiCount * startBlock + ((startBlock - 1) * (startBlock) * (2 * startBlock - 1)) / 6;
                break;
            }
        }
        while (flag) {
            endBlock++;
            int lastestBlockCountSum = ((endBlock) * (endBlock) + (endBlock)) / 2;
            if ( lastestBlockCountSum > end) {
                int resiCount = end - ((endBlock - 1) * (endBlock - 1) + (endBlock - 1)) / 2;
                resiCount++;
                endsum = resiCount * endBlock + ((endBlock - 1) * (endBlock) * (2 * endBlock - 1)) / 6;
                break;
            }
        }

        bw.write((endsum-startsum)+"");


        bw.flush();
        bw.close();
        br.close();
    }

}
