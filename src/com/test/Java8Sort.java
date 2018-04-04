package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Java8Sort {
	private Map<Long, String> map() {
		java.util.Map<Long, String> map = new LinkedHashMap();
		map.put(1l, "Analyst Briefing");
		map.put(3l, "Analyst Inquiry");
		map.put(4l, "CIO Leadership Forum");
		map.put(5l, "Event 1:1");
		map.put(6l, "Symposium");
		map.put(7l, "Consultation - Onsite");
		map.put(8l, "Consultation - Phone");
		map.put(9l, "Email - Customized Content");
		map.put(1l, "Facilitated Networking");
		map.put(11l, "Onsite Workshop");
		map.put(12l, "Call");
		map.put(13l, "Call - Review and Plan");
		map.put(14l, "Consultation Email");
		map.put(15l, "Email");
		map.put(16l, "Leadership Development Coaching");
		map.put(17l, "Research Participation");
		map.put(18l, "To be determined");
		return map;
	}

	public static void main(String[] args) {
		java.util.Map<Long, String> newmap = new Java8Sort().map().entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		for (Entry<Long, String> entry : newmap.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		String[] inactiveReasonList = { "Onsite Analyst Briefing", "Inquiry w/Analyst", "Member Administration" };
		java.util.List<String> sorted = new ArrayList<>(Arrays.asList(inactiveReasonList)).stream().sorted()
				.collect(Collectors.toList());
		System.out.println(sorted);
	}
}
