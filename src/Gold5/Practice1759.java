package Gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice1759 {

    static int L, C;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        char[] enableAlphabet = new char[C];
        boolean[] visited = new boolean[C];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            enableAlphabet[i] = token.nextToken().charAt(0);
        }
        Arrays.sort(enableAlphabet);
        combination(enableAlphabet, visited, 0, C, L);

        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(char[] alphabet, boolean[] visited, int start, int poolSize, int r) {
        if (r == 0) {
            boolean test = verify(alphabet, visited, poolSize);
            if (test) {
                appender(alphabet, visited, poolSize);
            }
            return;

        }
        for (int i = start; i < poolSize; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(alphabet, visited, i + 1, poolSize, r - 1);
                visited[i] = false;
            }
        }
    }

    public static boolean verify(char[] alphabet, boolean[] visited, int poolSize) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        String alphbet = "bcdfghjzlmnpqrstvwxyz";
        char[] chars = alphbet.toCharArray();
        int vowelCount = 0;
        int elseCount = 0;
        for (int i = 0; i < poolSize; i++) {
            if (visited[i]) {
                for (int j = 0; j < vowel.length; j++) {
                    if (alphabet[i] == vowel[j]) {
                        vowelCount++;
                    }
                }
                for (int j = 0; j < chars.length; j++) {
                    if (alphabet[i] == chars[j]) {
                        elseCount++;
                    }
                }
            }
        }
        if (vowelCount > 0 && elseCount > 1) {
            return true;
        } else return false;
    }

    public static void appender(char[] alphabet, boolean[] visited, int poolSize) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < poolSize; i++) {
            if (visited[i]) {
                builder.append(alphabet[i]);
            }
        }
        list.add(builder.toString());
    }
}