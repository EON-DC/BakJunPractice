package Silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Practice17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        HashMap<String, String> note = new HashMap<>();
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            String web = token.nextToken();
            String pw = token.nextToken();
            note.put(web, pw);
        }
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String findWeb = br.readLine();
            String gottenPw = note.get(findWeb);
            resultList.add(gottenPw);
        }
        for (String s : resultList) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

