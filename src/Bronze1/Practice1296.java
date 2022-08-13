package Bronze1;

import java.io.*;
import java.util.Arrays;

public class Practice1296 {
    static String yonduName;
    static String[] teamNameList;
    static int tc;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        yonduName = br.readLine();
        tc = Integer.parseInt(br.readLine());
        teamNameList = new String[tc];
        int maxScore = -1;
        String maxTeamName = "z"; // 대문자에 비해 사전적으로 무조건 후순위
        for (int i = 0; i < tc; i++) {
            teamNameList[i] = br.readLine();
            int tempResult = calcul(teamNameList[i]);
            if (maxScore < tempResult) {
                maxScore = tempResult;
                maxTeamName = teamNameList[i];
            } else if (maxScore == tempResult) {
                String[] sorting = new String[2];
                sorting[0] = maxTeamName;
                sorting[1] = teamNameList[i];
                Arrays.sort(sorting);
                maxTeamName = sorting[0];
            }
        }
        bw.write(maxTeamName);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calcul(String s) {
        int[] love = new int[4]; // 인덱스 0~ L letter count
        for (int i = 0; i < yonduName.length(); i++) {
            switch (yonduName.charAt(i)) {
                case 'L':
                    love[0]++;
                    break;
                case 'O':
                    love[1]++;
                    break;
                case 'V':
                    love[2]++;
                    break;
                case 'E':
                    love[3]++;
                    break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'L':
                    love[0]++;
                    break;
                case 'O':
                    love[1]++;
                    break;
                case 'V':
                    love[2]++;
                    break;
                case 'E':
                    love[3]++;
                    break;
            }
        }
        int result = (love[0] + love[1]) * (love[0] + love[2]) * (love[0] + love[3])
                * (love[1] + love[2]) * (love[1] + love[3]) * (love[2] + love[3]) % 100;

        return result;
    }
}
