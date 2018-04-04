package com.test;

import java.util.Arrays;

public class Test4 {

	public static void main(String[] args) {
		int A[] = { 2, -4, 6, -3, 9 };
		int parSumA[] = new int[A.length];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			parSumA[i] = sum + A[i];
			sum = sum + A[i];
		}

		Arrays.sort(parSumA);
		for(int i = 0; i < parSumA.length; i++) {
			System.out.println(parSumA[i]);
		}
		int min = Integer.MAX_VALUE;
		int pos1 = 0, pos2 = 0;
		for (int j = 0; j < parSumA.length; j++) {
			for (int k = j + 1; k < parSumA.length; k++) {
				if (calculateDistance(parSumA[j], parSumA[k]) < min) {
					min = calculateDistance(parSumA[j], parSumA[k]);;
					pos1 = j;
					pos2 = k;
				}
			}
		}
		System.out.println("The closest two points are " + "(" + pos1 + ", " + pos2 + ")");
		int minAbsSum = 0;
		for(int l = pos1; l <= pos2; l++) {
			minAbsSum = minAbsSum + A[l];
		}
		System.out.println("FINAL: " + minAbsSum);
	}

	public static int calculateDistance(int a, int b) {
		return Math.abs(a - b);
	}

}
