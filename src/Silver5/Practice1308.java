package Silver5;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Practice1308 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startDate = br.readLine().split(" ");
        String[] endDate = br.readLine().split(" ");

        int startYear = Integer.parseInt(startDate[0]);
        int startMonth = Integer.parseInt(startDate[1]);
        int startDay = Integer.parseInt(startDate[2]);

        int endYear = Integer.parseInt(endDate[0]);
        int endMonth = Integer.parseInt(endDate[1]);
        int endDay = Integer.parseInt(endDate[2]);

        long countOfStartDay = countOfDays(startYear, startMonth, startDay);
        long countOfEndDay = countOfDays(endYear, endMonth, endDay);

        if ((startYear + 1000 < endYear)
                || (startYear + 1000 == endYear && startMonth < endMonth)
                || (startYear + 1000 == endYear && startMonth == endMonth && startDay <= endDay)) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + (countOfEndDay - countOfStartDay));
        }


    }

    private static int[] dayOfMonth(int year) {
        int[] endOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0)
                && (year % 100 != 0)
                || (year % 400 == 0)) {
            endOfMonth[1] = 29;
        }
        return endOfMonth;
    }

    private static long countOfDays(int year, int month, int day) {
        long dayCount = 0;
        int[] date;
        for (int i = 1; i < year; i++) {
            date = dayOfMonth(i);
            for (int j = 0; j < 12; j++) {
                dayCount += date[j];
            }
        }
        date = dayOfMonth(year);
        for (int i = 0; i < month - 1; i++) {
            dayCount += date[i];
        }
        dayCount += day;
        return dayCount;
    }
}
