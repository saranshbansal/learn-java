package com.datastructures.arrays;

public class IntegerToRomanArrayList {
    public static void main(String[] args) {
        int[] num = {75, 80, 99};
        String[] res = IntegerToRomanArrayList.romanizer(num);
        for (String s : res) {
            System.out.println(s);
        }
    }


    static String[] romanizer(int[] num) {
        String[] ans = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            ans[i] = convertToRoman(num[i]);
        }
        return ans;
    }


    static String convertToRoman(int val) {
        String res = "";
        String[] huns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        while (val >= 1000) {
            res = res + 'M';
            val -= 1000;
        }

        res = res + huns[val / 100];
        val = val % 100;

        res = res + tens[val / 10];
        val = val % 10;

        res = res + ones[val];
        return res;
    }
}
