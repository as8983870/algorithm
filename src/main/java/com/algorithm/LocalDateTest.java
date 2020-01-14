package com.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTest {
    public static void main(String[] args) {

        String aa = "2019-12-12";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = null;
        try {
            nowDate = simpleDateFormat.parse(aa);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(nowDate.getTime());

        LocalDate deadline = LocalDate.parse(aa, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = deadline.atStartOfDay(zoneId);
        System.out.println(zdt.toInstant().toEpochMilli());


    }
}
