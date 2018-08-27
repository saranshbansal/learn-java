package com.scratchpad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOps
{
    private static final Map<String, Long> phaseOrderMap = new HashMap<>();
    static
    {
        phaseOrderMap.put("Strategize and Plan", 1l);
        phaseOrderMap.put("Acquire", 2l);
        phaseOrderMap.put("Operate and Evolve", 3l);
    }


    public static void main(String[] args)
    {
        java.util.List<String> keys = (List<String>) phaseOrderMap.entrySet().stream().filter(e -> e.getValue() > 1).map(en -> {
            return en.getKey();
        }).collect(Collectors.toList());
        System.out.println(keys);
    }

}
