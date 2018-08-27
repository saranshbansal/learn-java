package com.scratchpad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil
{
    private static final SimpleDateFormat MMMyyyyDateFormat = new SimpleDateFormat("MMM yyyy");
    private static final SimpleDateFormat MMddyyyyDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    public static final SimpleDateFormat MMddyyyyTimeDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    public static final SimpleDateFormat yyyyMMddTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    public static String getUtilDateFromString(String strDate, SimpleDateFormat format) throws ParseException
    {
        Date convertedCurrentDate = format.parse(strDate);
        String date = format.format(convertedCurrentDate);
        return date;
    }


    public static synchronized String getDateFormatMMMyyyy(String dateString) throws ParseException
    {
        return MMMyyyyDateFormat.format(MMddyyyyDateFormat.parse(dateString));
    }


    public static synchronized Date getDateFormatMMddMyyyy(String dateString) throws ParseException
    {
        return MMddyyyyDateFormat.parse(dateString);
    }


    public static synchronized Date getDateFormatMMddMyyyyTime(String dateString) throws ParseException
    {
        return MMddyyyyTimeDateFormat.parse(dateString);
    }


    public static synchronized XMLGregorianCalendar getDateFormatyyyyMMddTime(String dateString)
        throws ParseException, DatatypeConfigurationException
    {
        Date utilDate = yyyyMMddTimeDateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utilDate);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(utilDate);
        XMLGregorianCalendar xmlDate3 =
            DatatypeFactory.newInstance().newXMLGregorianCalendar(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), hours, minutes,
                seconds, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        return xmlDate3;
    }


    public static void main(String[] args)
    {
        try
        {
            System.out.println(getDateFormatMMMyyyy("02/07/2017 11:56:00").toUpperCase());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
