package com.scratchpad;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Progressions {
	public static void main(String[] args) {
		Map<Integer, String> calendarDateMap = new HashMap<>();
		String[] dateRange = null;
		try {
			dateRange = GartnerDateTimeUtil.calendarRangeList("01 FEB 2017", "31 AUG 2018", 3l, 5l, 3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendarDateMap = GartnerDateTimeUtil.getMMMyyyyCalendarRangeMap(dateRange, 3, String.valueOf(','));
		System.out.println(calendarDateMap);
	}

}
