package com.datastructures.arrays;

import static java.util.Arrays.sort;

public class RemoveElementInPlace {

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
     *
     * @param nums integer array
     * @param val  value to be deleted
     * @return last index of the updated array
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2}; // Input array
        int[] expectedNums = new int[]{2}; // The expected answer with correct length
        int val = 3; // element to remove

        int k = removeElement(nums, val); // Calls your implementation

        // Test assertions
        assert k == expectedNums.length;
        sort(nums, 0, k);
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
