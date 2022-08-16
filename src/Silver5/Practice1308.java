package Silver5;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Practice1308 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] start = new int[3];
        int[] dDayInt = new int[3];
        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            dDayInt[i] = Integer.parseInt(token.nextToken());
        }


        // String 화
        String startDay = "";
        startDay += String.valueOf(start[0]) + " ";
        if (start[1] <= 9) {
            startDay += "0" + String.valueOf(start[1]);
        } else {
            startDay += String.valueOf(start[1]);
        }
        startDay += " " + String.valueOf(start[2]);

        String dDay = "";
        dDay += String.valueOf(dDayInt[0]) + " ";
        if (dDayInt[1] <= 9) {
            dDay += "0" + String.valueOf(dDayInt[1]);
        } else {
            dDay += String.valueOf(dDayInt[1]);
        }
        dDay += " " + String.valueOf(dDayInt[2]);


        // SimpleDateFormat 화
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy MM dd");
        Calendar scal = Calendar.getInstance();
        Calendar dcal = Calendar.getInstance();

        Date startDt = formattedDate.parse(startDay);
        Date dDayDt = formattedDate.parse(dDay);
        scal.setTime(startDt);
        dcal.setTime(dDayDt);
        // 1000년 검증
        scal.add(Calendar.YEAR, 1000);
        int verify = scal.getTime().compareTo(dDayDt);
        if (verify < 0) {
            System.out.println("gg");
            return;
        } else {
            scal.add(Calendar.YEAR, -1000);
        }

        // day 누적해서 남은 날짜가 몇일인지?
        int dayCount = 0;
        while (true) {
            if (scal.getTime().compareTo(dDayDt) == 0) {
                break;
            } else {
                scal.add(Calendar.DATE, 1);
                dayCount++;
            }
        }
        bw.write("D-" + dayCount);


        bw.flush();
        bw.close();
        br.close();

    }
}
