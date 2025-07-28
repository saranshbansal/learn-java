package com.datastructures.arrays;

public class SearchInsert {

	/**
	 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
	 * return the index where it would be if it were inserted in order.
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		int targetPos = 0;

		for (int i = 0; i < nums.length; i++) {
			if (target == nums[i]) {
				return i;
			}

			if (target > nums[i]) {
				targetPos++;
			}
		}

		return targetPos;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 5, 6}; // Input array
		int target = 2; // Element to be inserted

		int k = searchInsert(nums, target);
		System.out.println("Index to insert given element is: " + k);
	}
}
