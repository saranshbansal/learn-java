package com.scratchpad;

import java.util.TreeSet;

public class CompareExample
{
    public static void main(String args[])
    {
        String string1 = "H1";
        String string2 = "h3";
        String string3 = "H2";
        TreeSet<String> t = new TreeSet<>();
        t.add(string1);
        t.add(string2);
        t.add(string3);

        t.stream().forEach(o -> {
            System.out.println(o);
        });

        int var1 = string1.compareTo(string2);
        System.out.println("string1 and string2 comparison: " + var1);

        int var2 = string1.compareToIgnoreCase(string3);
        System.out.println("string1 and string3 comparison: " + var2);

        int var3 = string1.compareToIgnoreCase("HeLLo");
        System.out.println("string1 and HeLLo comparison: " + var3);
    }
}
