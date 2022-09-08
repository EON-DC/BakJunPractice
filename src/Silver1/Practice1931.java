package Silver1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Practice1931 {

    // 1931번 문제
    // 입력 파라 : 회의의 수
    // 둘째줄 : 회의가 열리는 시간에 대한 정보 줄, 0보다 크고 int 사용가능
    // 회의실이 한개뿐임
    // 끝나면 짧은 다른거 채워서 회의실 쓰게하고.
    // 그때의 개수 중 최대를 찾음

    static int MeetingNum;
    static int meetingList[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MeetingNum = Integer.parseInt(br.readLine());
        meetingList = new int[MeetingNum][2];
        for (int i = 0; i < MeetingNum; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int tempS = Integer.parseInt(token.nextToken());
            int tempE = Integer.parseInt(token.nextToken());
            meetingList[i][0] = tempS;
            meetingList[i][1] = tempE;
        }

        Arrays.sort(meetingList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prevEndTime = 0;
        for (int i = 0; i < MeetingNum; i++) {
            if (prevEndTime <= meetingList[i][0]) {
                prevEndTime = meetingList[i][1];
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}