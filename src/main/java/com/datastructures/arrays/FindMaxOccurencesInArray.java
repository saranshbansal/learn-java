package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

class FindMaxOccurencesInArray {

    public static void main(String[] args) {
        System.out.println(findMaxOccurrence(new int[]{4, 2, 6, 2, 2, 6, 6, 4}));
    }


    static int findMaxOccurrence(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> kvmap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!kvmap.containsKey(arr[i])) {
                kvmap.put(arr[i], i);
            } else {
                result = Math.max(result, i - kvmap.get(arr[i]));
            }
        }
        return result;
    }
}
