package com.expensetracker.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FunctionUtil {

    public static String toSentenceCase(String input) {
        if (input !=null || !input.isEmpty()) {
            return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
        }
        else
            return input;
    }

    public static LocalDateTime stringToLocalDateTime(String inputStringDate) {

        int year = Integer.parseInt(inputStringDate.substring(0,4));
        int month = Integer.parseInt(inputStringDate.substring(5,7));
        int dayOfMonth = Integer.parseInt(inputStringDate.substring(8,10));

        LocalDate date = LocalDate.of(year,month,dayOfMonth);
        LocalTime time = LocalTime.now();

        return LocalDateTime.of(date,time);
    }
}
