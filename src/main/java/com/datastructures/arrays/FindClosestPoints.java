package com.datastructures.arrays;

import java.util.Arrays;

public class FindClosestPoints {

    public static void main(String[] args) {
        int[] arr = {2, -4, 6, -3, 9};
        int[] parSumA = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            parSumA[i] = sum + arr[i];
            sum = sum + arr[i];
        }

        Arrays.sort(parSumA);
        for (int value : parSumA) {
            System.out.println(value);
        }
        int min = Integer.MAX_VALUE;
        int pos1 = 0;
        int pos2 = 0;
        for (int j = 0; j < parSumA.length; j++) {
            for (int k = j + 1; k < parSumA.length; k++) {
                if (calculateDistance(parSumA[j], parSumA[k]) < min) {
                    min = calculateDistance(parSumA[j], parSumA[k]);
                    pos1 = j;
                    pos2 = k;
                }
            }
        }
        System.out.println("The closest two points are " + "(" + pos1 + ", " + pos2 + ")");
        int minAbsSum = 0;
        for (int l = pos1; l <= pos2; l++) {
            minAbsSum = minAbsSum + arr[l];
        }
        System.out.println("FINAL: " + minAbsSum);
    }


    public static int calculateDistance(int a, int b) {
        return Math.abs(a - b);
    }
}
