package com.datastructures.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

public class ArraySumEqualsK {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (i != j && nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] result = twoSum(new int[]{3, 6, 3}, 6);

		Arrays.stream(result)
				.forEach(System.out::println);
	}
}
