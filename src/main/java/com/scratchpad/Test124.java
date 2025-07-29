package com.scratchpad;

import java.util.*;
import java.util.stream.Collectors;

public class Test124 {
    public static void main(String[] args) {
    }


    public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
        callLogs.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));

        Set<Integer> inCache = new HashSet<>();

        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (List<Integer> log : callLogs) {
            int thisItem = log.get(1);

            if (cacheMap.containsKey(thisItem)) {
                cacheMap.put(thisItem, cacheMap.get(thisItem) + 2);
                // decrease others by 1
                cacheMap.entrySet().stream().filter(obj -> obj.getKey() != thisItem).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue() - 1));

                if (cacheMap.get(thisItem) > 5) {
                    inCache.add(thisItem);
                } else inCache.remove(thisItem);
            } else {
                cacheMap.put(thisItem, 2);
            }
        }

        return new ArrayList<>(inCache);
    }
}
