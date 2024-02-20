package com.datastructures.arrays;

import java.util.Arrays;

public class AddKToArray {

	/**
	 * Given a non-empty array of decimal digits representing a non-negative
	 * integer, increment array by target number and return the result.
	 *
	 * @param digits   original array
	 * @param numToAdd number to add to the last digit
	 * @return new array
	 */
	public static int[] plusK(int[] digits, int numToAdd) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			int sum = digits[i] + numToAdd;
			digits[i] = sum % 10; // Update the digit
			numToAdd = sum / 10; // Get the carry

			if (numToAdd == 0) {
				// If no more carry, we can stop
				return digits;
			}
		}

		// If we reached here, we need to add another digit
		int[] result = new int[n + 1];
		result[0] = 1; // Set the first digit to 1
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 9, 9}; // Input array
		int k = 3;

		int[] numsPlusOne = plusK(nums, k);
		System.out.println(Arrays.toString(numsPlusOne));
	}
}
