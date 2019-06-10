package com.scratchpad;

import java.util.LinkedHashSet;
import java.util.Set;

public class Output1
{
    public static void main(String[] args)
    {
        Set<String> setObj = new LinkedHashSet<>();
        setObj.add("Java");
        
        Set<String> newSetObj = java.util.Collections.unmodifiableSet(setObj);
        newSetObj.add("Program"); // unmodifiable collection error @ runtime
        
        System.out.println(" " + newSetObj);
        
    }
}
