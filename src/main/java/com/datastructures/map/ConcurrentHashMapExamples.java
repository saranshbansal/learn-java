package com.datastructures.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExamples {

    /**
     * Shows various operations on a ConcurrentHashMap:
     * <ul>
     * <li>puts a key-value pair and gets the value</li>
     * <li>puts a key-value pair if the key is not already present</li>
     * <li>replaces a key-value pair if the key is already present</li>
     * <li>removes a key-value pair if the key is present</li>
     * <li>merges a value into an existing key-value pair</li>
     * </ul>
     */
    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<>();

        // Put and get
        chm.put("key1", "value1");


        Object value1 = chm.get("key1");
        System.out.println("value1 = " + value1);

        // Put if absent
        String value2 = (String) chm.putIfAbsent("key2", "value2");
        System.out.println("value2 = " + value2);

        // Replace
        String value3 = (String) chm.replace("key2", "value3");
        System.out.println("value3 = " + value3);

        // Remove
        String value4 = (String) chm.remove("key2");
        System.out.println("value4 = " + value4);

        // Merge
        chm.merge("key1", "value1", (v1, v2) -> v1 + (String) v2);
        String value5 = (String) chm.get("key1");
        System.out.println("value5 = " + value5);
    }
}
