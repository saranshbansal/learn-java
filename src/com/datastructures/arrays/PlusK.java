package com.datastructures.arrays;

import java.util.Arrays;

public class PlusK {

	/**
	 * Given a non-empty array of decimal digits representing a non-negative
	 * integer, increment array by target number and return the result.
	 *
	 * @param digits original array
	 * @return new array
	 */
	public static int[] plusOne(int[] digits, int numToAdd) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] + numToAdd < 10) {
				digits[i] = digits[i] + numToAdd;
				return digits;
			}
			digits[i] = 0;
		}

		// all digits are 0, increase array size itself
		digits = new int[n + 1];
		digits[0] = 1;

		return digits;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 9, 9}; // Input array
		int k = 3;

		int[] numsPlusOne = plusOne(nums, k);
		System.out.println(Arrays.toString(numsPlusOne));
	}
}
