package com.scratchpad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Utility class for Date-Time conversion to standard formats used in Gartner applications
 * 
 * @author sbansal
 */
public class GartnerDateTimeUtil
{

    // Define formats here
    private static final SimpleDateFormat MMMyyyyDateFormat = new SimpleDateFormat("MMM yyyy");
    private static final SimpleDateFormat ddMMMyyyyDateFormat = new SimpleDateFormat("dd MMM yyyy");
    private static final SimpleDateFormat MMddyyyyDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    public static final SimpleDateFormat yyyyMMDDDateFormat = new SimpleDateFormat("yyyy-MM-DD");
    public static final SimpleDateFormat MMddyyyyTimeDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    public static final SimpleDateFormat yyyyMMddTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static final SimpleDateFormat utcDateFormat = new SimpleDateFormat("dd MMM yyyy");
    public static final SimpleDateFormat utcDateFormatWithTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private static final DateTimeFormatter MMMyyyyDateFormatJava8 = DateTimeFormatter.ofPattern("MMM yyyy");
    private static final DateTimeFormatter ddMMMyyyyDateFormatJava8 = DateTimeFormatter.ofPattern("dd MMM yyyy");
    public static final DateTimeFormatter yyyyMMDDDateFormatJava8 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static
    {
        utcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        utcDateFormatWithTime.setTimeZone(TimeZone.getTimeZone("UTC"));
    }


    public static synchronized Date getDateFormatddMMMyyyy(String dateString) throws ParseException
    {
        Date date = null;
        if (StringUtils.isNotBlank(dateString))
        {
            date = ddMMMyyyyDateFormat.parse(dateString);
        }
        return date;
    }


    public static synchronized Date getDateFromStringMMMyyyy(String dateString) throws ParseException
    {
        Date date = null;
        if (StringUtils.isNotBlank(dateString))
        {
            date = MMMyyyyDateFormat.parse(dateString);
        }
        return date;
    }


    public static synchronized Date getDateFormatMMddyyyy(String dateString) throws ParseException
    {
        return MMddyyyyDateFormat.parse(dateString);
    }


    public static synchronized String getDateFormatMMddyyyy(Date date) throws ParseException
    {
        return MMddyyyyDateFormat.format(date);
    }


    public static synchronized Date getDateFormatyyyyMMDD(String dateString) throws ParseException
    {
        return yyyyMMDDDateFormat.parse(dateString);
    }


    public static synchronized String getStringFormatddMMMyyyy(Date date)
    {
        String stringDate = "";
        if (null != date)
        {
            stringDate = ddMMMyyyyDateFormat.format(date);
        }
        return stringDate;
    }


    public static synchronized String getStringFormatddMMMyyyy(String date) throws ParseException
    {
        return ddMMMyyyyDateFormat.format(MMddyyyyDateFormat.parse(date));
    }


    public static synchronized Date getDateFormatMMddyyyyTime(String dateString) throws ParseException
    {
        return MMddyyyyTimeDateFormat.parse(dateString);
    }


    public static synchronized String getDateFormatMMddyyyyTime(Date date) throws ParseException
    {
        String stringDate = "";
        if (null != date)
        {
            stringDate = MMddyyyyTimeDateFormat.format(date);
        }
        return stringDate;
    }


    public static synchronized String getDateFormatMMMyyyy(String dateString) throws ParseException
    {
        return MMMyyyyDateFormat.format(ddMMMyyyyDateFormat.parse(dateString));
    }


    public static synchronized String getDateFormatMMMyyyyFromMMddyyyy(String dateString) throws ParseException
    {
        return MMMyyyyDateFormat.format(MMddyyyyDateFormat.parse(dateString));
    }


    public static synchronized String getDateFormatMMMyyyyFromddMMMyyyy(String dateString) throws ParseException
    {
        return MMMyyyyDateFormat.format(ddMMMyyyyDateFormat.parse(dateString));
    }


    public static synchronized String getDateFormatMMMyyyyJava8(String date) throws ParseException
    {
        return MMMyyyyDateFormatJava8.format(yyyyMMDDDateFormatJava8.parse(date));
    }


    public static synchronized String convertDateToUTCFormat(Date date) throws ParseException
    {
        String dateToReturn = "";
        if (null != date)
        {
            dateToReturn = utcDateFormat.format(date);
        }
        return dateToReturn;
    }


    public static synchronized String convertDateToUTCFormatWithTime(Date date) throws ParseException
    {
        String dateToReturn = "";
        if (null != date)
        {
            dateToReturn = utcDateFormatWithTime.format(date);
        }
        return dateToReturn;
    }


    public static synchronized XMLGregorianCalendar getGregorianDateFormatyyyyMMdd(String dateString)
        throws ParseException, DatatypeConfigurationException
    {
        Date utilDate = ddMMMyyyyDateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utilDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(utilDate);
        XMLGregorianCalendar xmlDate =
            DatatypeFactory.newInstance().newXMLGregorianCalendar(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), hours, minutes, seconds,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        return xmlDate;
    }


    public static synchronized XMLGregorianCalendar getGregorianDateFromUtilDate(Date date)
        throws DatatypeConfigurationException
    {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlDate;
    }


    public static synchronized XMLGregorianCalendar getGregorianDateFromDDMMMyyyyDate(String dateString)
        throws DatatypeConfigurationException, ParseException
    {
        Date utilDate = ddMMMyyyyDateFormat.parse(dateString);
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(utilDate);
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlDate;
    }


    public static synchronized Map<Integer, String> getMMMyyyyCalendarRangeMap(
        String[] MMMyyyyArray, int breakAfter,
        CharSequence delim)
    {
        Map<Integer, String> MMMyyyyMap = new LinkedHashMap<>();
        int key = 0;
        int m = 0;
        for (int i = 0; i < MMMyyyyArray.length; i++)
        {
            String chunk = "";
            key++;
            if (i == 0)
            {
                chunk = String.join(delim, Arrays.copyOfRange(MMMyyyyArray, i, i + breakAfter));
                MMMyyyyMap.put(key, chunk);
            }
            else
            {
                // Algo -> start - (i*breakafter - 2*m) | end - (i*breakafter - 2*(m-1)) where m goes from 1 to infinite
                // and i is an increasing multiple of 3(breakafter)
                m++;
                int from = (i * breakAfter - 2 * m);
                int to = (i * breakAfter - 2 * (m - 1)) + 1;
                if (from <= MMMyyyyArray.length && to <= MMMyyyyArray.length)
                {
                    chunk = String.join(delim, Arrays.copyOfRange(MMMyyyyArray, from, to));
                    MMMyyyyMap.put(key, chunk);
                }
            }
        }
        return MMMyyyyMap;
    }


    public static synchronized String[] calendarRangeList(
        String startrDate, String endDate, Long monthBefore,
        Long monthAfter, Integer breakAfter)
        throws ParseException
    {
        LocalDate start = LocalDate.parse(WordUtils.capitalizeFully(startrDate), ddMMMyyyyDateFormatJava8);
        LocalDate end = LocalDate.parse(WordUtils.capitalizeFully(endDate), ddMMMyyyyDateFormatJava8);
        LocalDate adjustedStart = start.minusMonths(monthBefore);
        LocalDate adjustedStop = end.plusMonths(monthAfter);
        long numOfDaysBetween = ChronoUnit.DAYS.between(adjustedStart, adjustedStop);
        List<LocalDate> localDates =
            IntStream
                .iterate(0, i -> i + 1).limit(numOfDaysBetween)
                .mapToObj(i -> adjustedStart.plusDays(i)).collect(Collectors.toList());
        LinkedHashSet<String> dates = new LinkedHashSet<>();
        for (LocalDate date : localDates)
        {
            dates.add(getDateFormatMMMyyyyJava8(date.toString()).toUpperCase());
        }
        return dates.toArray(new String[dates.size()]);
    }

}
