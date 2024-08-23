package ex_240822;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PracticeDate {

    public static void main(String[] args) {
        // 날짜를 문자열로
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        DateTimeFormatter koreanFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        String format = zonedDateTime.format(koreanFormatter);

        System.out.println(format);


        // 문자열을 날짜로
        String dateTimeString = "2024년 08월 22일";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString + " 00시 00분 00초", DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

            // 문자열을 ZonedDateTime으로 파싱
            ZonedDateTime zonedDateTime2 = localDateTime.atZone(ZoneId.of("Asia/Seoul"));

            System.out.println(zonedDateTime2);
        } catch (DateTimeParseException e) {
            System.err.println("DateTimeParseException: " + e.getMessage());
        }

    }
}
