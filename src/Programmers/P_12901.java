package Programmers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class P_12901 {
    public static void main(String[] args) throws ParseException {
        String result = solution(2, 4);
        System.out.println(result);
    }


    static public String solution(int a, int b) throws ParseException {
        String answer = "";
        a--;
        // 자바 calendar 넣고, month, day 증감하고 반환할 때, 요일로 받기
        String anker = "20160101";
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");
        Date ankerDate = formattedDate.parse(anker);
        Calendar cal = Calendar.getInstance();
        cal.setTime(ankerDate);
        cal.add(Calendar.MONTH, a);
        cal.add(Calendar.DATE, b);
        System.out.println("cal.getTime().toString() = " + cal.getTime().toString());
        return cal.getTime().toString().substring(0,3).toUpperCase();
    }
}
