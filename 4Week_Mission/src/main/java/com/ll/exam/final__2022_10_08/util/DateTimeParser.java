package com.ll.exam.final__2022_10_08.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DateTimeParser {
    public static List<Integer> dateTimeToIntegerList(LocalDateTime localDateTime) {
        List<Integer> result = new ArrayList<>();
        result.add(localDateTime.getYear());
        result.add(localDateTime.getMonthValue());
        result.add(localDateTime.getDayOfMonth());
        result.add(localDateTime.getHour());
        result.add(localDateTime.getMinute());
        result.add(localDateTime.getSecond());
        result.add(localDateTime.getNano());
        return result;
    }
}
