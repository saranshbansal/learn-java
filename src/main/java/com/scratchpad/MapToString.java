package com.scratchpad;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.strip;

public class MapToString {
    public static void main(String[] args) {
        Map<String, Object> someMap = new HashMap<>();
        someMap.put("key", "value");
        someMap.put("key2", "value2");
        someMap.put("key3", null);
        someMap.values().removeIf(Objects::isNull);
        String output = StringUtils.join(someMap);
        System.out.println(strip(output, "[]"));
    }
}
