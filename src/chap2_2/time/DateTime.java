package chap2_2.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

    public static void main(String[] args) {

        // 날짜와 시간을 표현
        // 1970년 1월 1일 00:00:00 이전의 시간은 모름 - 에폭 타임 (유닉스 타임)
        // 밀리초 단위로 시간을 늘려나감
        System.out.println(System.currentTimeMillis());

        // 자바 8 이전
        Date date = new Date();
        System.out.println("date: " + date);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.JULY);

        // 자바 8 이후
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);

        LocalTime nowTime = LocalTime.now();
    }
}
