package com.scratchpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Java8Sort {
    public static void main(String[] args) {
        java.util.Map<Long, String> newmap =
                new Java8Sort()
                        .map().entrySet().stream()
                        .sorted(Map.Entry.comparingByValue()).collect(
                                Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Entry<Long, String> entry : newmap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        String[] inactiveReasonList = {"Onsite Analyst Briefing", "Inquiry w/Analyst", "Member Administration"};
        java.util.List<String> sorted =
                new ArrayList<>(Arrays.asList(inactiveReasonList))
                        .stream().sorted()
                        .collect(Collectors.toList());
        System.out.println(sorted);
    }

    private Map<Long, String> map() {
        java.util.Map<Long, String> map = new LinkedHashMap();
        map.put(1L, "Analyst Briefing");
        map.put(3L, "Analyst Inquiry");
        map.put(4L, "CIO Leadership Forum");
        map.put(5L, "Event 1:1");
        map.put(6L, "Symposium");
        map.put(7L, "Consultation - Onsite");
        map.put(8L, "Consultation - Phone");
        map.put(9L, "Email - Customized Content");
        map.put(1L, "Facilitated Networking");
        map.put(11L, "Onsite Workshop");
        map.put(12L, "Call");
        map.put(13L, "Call - Review and Plan");
        map.put(14L, "Consultation Email");
        map.put(15L, "Email");
        map.put(16L, "Leadership Development Coaching");
        map.put(17L, "Research Participation");
        map.put(18L, "To be determined");
        return map;
    }
}
