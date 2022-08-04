package Bronze4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Practice1264 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vowel = "aeiouAEIOU";
        List<String> vowelList = new ArrayList<>();
        for (int i = 0; i < vowel.length(); i++) {
            vowelList.add(String.valueOf(vowel.charAt(i)));
        }
        String s = br.readLine();
        do {
            int vowelCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (vowelList.contains(String.valueOf(s.charAt(i)))) {
                    vowelCount++;
                }
            }
            System.out.println(vowelCount);
            s = br.readLine();
        } while (s.equals("#") == false);
    }
    public static void main(String[] args) throws Exception {
        new Practice1264().solution();
    }
}

