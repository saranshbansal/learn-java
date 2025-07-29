package com.scratchpad;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Formatter {

    public static void main(String[] args) {
        String PATTERN = "dd MMM yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern(PATTERN);
        String date1 = dateFormat.format(Calendar.getInstance().getTime());
        System.out.println(date1.toUpperCase());

        String phoneNum = "9176470369";
        System.out.println(phoneNum.replace(" ", "").replaceFirst("(\\d{3})(\\d{3})(\\d+)", "+ $1 $2 $3"));
    }

}
