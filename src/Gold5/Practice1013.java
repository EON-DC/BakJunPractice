package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Practice1013 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        Pattern P = Pattern.compile("(100+1+|01)+");

        while (T-- > 0) {
            if (P.matcher(br.readLine()).matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
