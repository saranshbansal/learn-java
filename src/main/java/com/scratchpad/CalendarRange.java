package com.scratchpad;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.text.WordUtils.capitalizeFully;

public class CalendarRange {
    public static final DateTimeFormatter yyyyMMDDDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MMMyyyyDateFormat = DateTimeFormatter.ofPattern("MMM yyyy");
    private static final DateTimeFormatter ddMMMyyyyDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static synchronized String getDateFormatMMMyyyy(String date) {
        return MMMyyyyDateFormat.format(yyyyMMDDDateFormat.parse(date));
    }


    public static java.util.List<LocalDate> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream
                .iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) throws ParseException {
        System.out.println(capitalizeFully("01 JUL 2016"));
        LinkedHashSet<String> dates = new LinkedHashSet<>();
        LocalDate startDate = LocalDate.parse("01 Jul 2016", ddMMMyyyyDateFormat);
        LocalDate endDate = LocalDate.parse("31 Jul 2017", ddMMMyyyyDateFormat);
        java.util.List<LocalDate> localDates = getDatesBetweenUsingJava8(startDate, endDate)
                .parallelStream()
                .distinct()
                .toList();
        for (LocalDate date : localDates) {
            dates.add(getDateFormatMMMyyyy(date.toString()));
        }
        dates.toArray();
        for (String date : dates) {
            System.out.println(date.toUpperCase());
        }
    }

}
