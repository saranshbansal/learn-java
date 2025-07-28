package com.scratchpad;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalendarScroller {

	static {
		String[] my =
				{
						"JAN 2016", "FEB 2016", "MAR 2016", "APR 2016", "MAY 2016", "JUN 2016", "JUL 2016", "AUG 2016",
						"SEP 2016", "OCT 2016", "NOV 2016", "DEC 2016", "JAN 2017", "FEB 2017", "MAR 2017", "APR 2017",
						"MAY 2017", "JUN 2017", "JUL 2017", "AUG 2017", "SEP 2017", "OCT 2017", "NOV 2017", "DEC 2017"};

		Map<Integer, String> myMap = new LinkedHashMap<>();
		int key = 0;
		for (int i = 0; i < my.length; i++) {
			String chunk = "";
			if (i % 3 == 0) {
				key++;
				chunk = String.join(",", Arrays.copyOfRange(my, i, i + 3));
				System.out.println(chunk);
				myMap.put(key, chunk);
			}

		}
		for (Map.Entry<Integer, String> chunk : myMap.entrySet()) {
			System.out.println("map[" + chunk.getKey() + "]" + " - " + chunk.getValue());
		}
	}


	public static void main(String[] args) {

	}
}
