package com.datastructures.arrays;

import java.util.LinkedList;
import java.util.List;

public class AddKToArray {

	/**
	 * Given a non-empty array of decimal digits representing a non-negative
	 * integer, increment array by target number and return the result.
	 *
	 * @param digits   original array
	 * @param numToAdd number to add to the last digit
	 * @return new array
	 */
	public static List<Integer> plusK(int[] digits, int numToAdd) {
		int n = digits.length;
		List<Integer> l = new LinkedList<>();
		for (int i = 0; i < n || numToAdd != 0; i++) {
			if (i < n)
				numToAdd += digits[n - i - 1];
			l.add(0, numToAdd % 10);
			numToAdd = numToAdd / 10;
		}
		return l;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0}; // Input array
		int k = 1000;

		List<Integer> numsPlusk = plusK(nums, k);
		numsPlusk.forEach(System.out::println);
	}
}
