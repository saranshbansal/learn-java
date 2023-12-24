package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.TRUE;

public class RemoveDuplicatesInPlace {
	public static int removeDuplicates(int[] nums) {
		Map<Integer, Boolean> visitorMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (visitorMap.getOrDefault(nums[i], false) == TRUE) {
				deleteElemFromArray(nums, nums[i]);
			} else {
				visitorMap.put(nums[i], true);
			}
		}

		return visitorMap.keySet().size();
	}

	private static int deleteElemFromArray(int[] arr, int elementToDelete) {
		int n = arr.length;
		int i;

		// Find the index of the element to be deleted
		for (i = 0; i < n; i++) {
			if (arr[i] == elementToDelete) {
				break;
			}
		}

		// If the element is not present in the array
		if (i == n) {
			return n;
		}

		// Shift elements to fill the gap
		for (int j = i; j < n - 1; j++) {
			arr[j] = arr[j + 1];
		}

		return n - 1; // Return the new size of the array
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 2, 1}; // Input array
		int[] expectedNums = new int[]{1, 2, 3}; // The expected answer with correct length

		int k = removeDuplicates(nums); // Calls your implementation

		assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
			assert nums[i] == expectedNums[i];
		}
	}
}
