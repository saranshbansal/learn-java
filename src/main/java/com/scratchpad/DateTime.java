package com.scratchpad;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTime {
    private static final SimpleDateFormat ddmmmyyyyDateFormat = new SimpleDateFormat("dd MMM yyyy");
    private static final SimpleDateFormat ddmmmyyyyDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");


    public static void main(String[] args) {
        try {
            System.out.println(addOneDay("26-Feb-2018"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    static public String addOneDay(String date) throws ParseException {
        return ddmmmyyyyDateFormat.format(ddmmmyyyyDateFormat2.parse(date));
    }

}
