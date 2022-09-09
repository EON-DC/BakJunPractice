package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] toSub = line.split("-");
        int result = 0;
        boolean isFirst = true;
        for (int i = 0; i < toSub.length; i++) {
            String[] toPlus = toSub[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < toPlus.length; j++) {
                sum += Integer.parseInt(toPlus[j]);
            }
            if (isFirst) {
                result += sum;
                isFirst = false;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }

}
