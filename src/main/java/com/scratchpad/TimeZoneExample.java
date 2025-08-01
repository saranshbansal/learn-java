package com.scratchpad;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeZoneExample {

    public static void main(String[] args) {

        String[] ids = TimeZone.getAvailableIDs();
        //System.out.println(ZoneId.getAvailableZoneIds());
        for (String id : ids) {
            System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
        }

        System.out.println("\nTotal TimeZone ID " + ids.length);

    }


    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes =
                TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                        - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

        return result;

    }

}
