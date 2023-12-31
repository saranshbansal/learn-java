package com.datastructures.arrays;

import static java.util.Arrays.sort;

public class RemoveDuplicatesInPlace {
	public static int removeDuplicates(int[] nums) {
		// Sort un-sorted array
		sort(nums);

		int n = nums.length;
		int k = 0;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] != nums[i+1]) {
				nums[k++] = nums[i];
			}
		}
		nums[k++] = nums[n-1];

		return k;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 2, 1}; // Input array
		int[] expectedNums = new int[]{1, 2, 3}; // The expected answer with correct length

		int k = removeDuplicates(nums); // Calls your implementation

		// Test assertions
		assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
			assert nums[i] == expectedNums[i];
		}
	}
}
