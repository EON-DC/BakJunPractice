package Silver1;

import java.io.*;
import java.util.StringTokenizer;

public class Practice1149 {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static int price[][];
    public static int ans[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        price = new int[num][3];
        ans = new int[num][3];
        for (int i = 0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            price[i][Red] = Integer.parseInt(token.nextToken());
            price[i][Green] = Integer.parseInt(token.nextToken());
            price[i][Blue] = Integer.parseInt(token.nextToken());
        }

        ans[0][Red] = price[0][Red];
        ans[0][Green] = price[0][Green];
        ans[0][Blue] = price[0][Blue];

        bw.write(Math.min(paint(num - 1, Red),
                Math.min(paint(num - 1, Blue), paint(num - 1, Green))) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int paint(int index, int color) {
        if (ans[index][color] == 0) {
            switch (color) {
                case Red:
                    ans[index][Red] = Math.min(paint(index - 1, Green),
                            paint(index - 1, Blue)) + price[index][Red];
                    break;
                case Green:
                    ans[index][Green] = Math.min(paint(index - 1, Red),
                            paint(index - 1, Blue)) + price[index][Green];
                    break;
                case Blue:
                    ans[index][Blue] = Math.min(paint(index - 1, Green),
                            paint(index - 1, Red)) + price[index][Blue];
                    break;
            }
        }
        return ans[index][color];
    }
}
