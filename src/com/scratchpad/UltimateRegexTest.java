package com.scratchpad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class UltimateRegexTest
{
    public static void main(String[] args)
    {
        String input = null; // "Specific Date: 29 Sep 2017 Date Range Option 1: 05 Sep 2017- 13 Sep 2017 Date Range Option 2: 05 Sep 2017- 13 Sep 2017 Date Range Option 2: 05 Sep 2017- 13 Sep 2017";
        if (StringUtils.contains(input, "Date Range Option 1:") && StringUtils.contains(input, "Date Range Option 2:"))
        {
            String s2 = StringUtils.substringBetween(input, "Date Range Option 1:", "Date Range Option 2:").trim();
            if (null != s2 && s2.contains("-") && isValidFormat("dd MMM yyyy", s2.split("-")[0]))
            {
                System.out.println("Op1-" + s2.split("-")[0].trim());
            }
            if (null != s2 && s2.contains("-") && isValidFormat("dd MMM yyyy", s2.split("-")[1]))
            {
                System.out.println("Op2-" + s2.split("-")[1].trim());
            }
        }
        if (StringUtils.contains(input, "Date Range Option 2:"))
        {
            String s3 = StringUtils.substringAfter(input, "Date Range Option 2:").trim();
            if (null != s3 && s3.contains("-") && isValidFormat("dd MMM yyyy", s3.split("-")[0]))
            {
                System.out.println("Op3-" + s3.split("-")[0].trim());
            }
            if (null != s3 && s3.contains("-") && isValidFormat("dd MMM yyyy", s3.split("-")[1]))
            {
                System.out.println("Op4-" + s3.split("-")[1].trim());
            }
        }
    }


    public static boolean isValidFormat(String format, String value)
    {
        Date date = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value.trim());
            if (!value.trim().equals(sdf.format(date)))
            {
                date = null;
            }
        }
        catch (ParseException ex)
        {
            // ex.printStackTrace();
        }
        return date != null;
    }
}
