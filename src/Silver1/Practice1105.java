package Silver1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        String L = token.nextToken();
        String R = token.nextToken();

        char[] Ls = L.toCharArray();
        char[] Rs = R.toCharArray();
        int answer = 0;
        if(L.length() == R.length()){
            for(int i = 0; i< Ls.length ; i++){
                if(Ls[i] == Rs[i] && Ls[i] =='8'){
                    answer++;
                } else if (Ls[i]!= Rs[i]) {
                    break;
                }
            }
        }
        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
