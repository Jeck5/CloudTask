package com.example.event.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventDateTimeUtils {
    public static LocalDateTime getLdtFromYmdhTs(String ts, String ymdh) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
        try {
            LocalDateTime result = LocalDateTime.parse(ymdh, formatter);
            return result.plusNanos(Long.valueOf(ts) * 1000000L);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isDateTimeInLastMinutes(LocalDateTime dateTime, int minutes){
        return dateTime.compareTo(LocalDateTime.now().minusMinutes(minutes)) > 0;
    }


    public static void main(String[] args) {
        System.out.println(getLdtFromYmdhTs("1499763594", "2017-07-11-09"));
        System.out.println(isDateTimeInLastMinutes(getLdtFromYmdhTs("1499763594", "2017-07-11-09"),230000));
        System.out.println(isDateTimeInLastMinutes(getLdtFromYmdhTs("1499763594", "2017-07-11-09"),600000));

    }
}