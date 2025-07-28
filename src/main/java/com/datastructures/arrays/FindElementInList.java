package com.datastructures.arrays;

import java.util.Arrays;

public class FindElementInList {
	static String findNumber(java.util.List<Integer> arr, int k) {
		Integer x = arr.stream().filter(obj -> obj == k).findFirst().orElse(null);

		return x == null ? "NO" : "YES";
	}


	public static void main(String[] args) {
		System.out.println(findNumber(Arrays.asList(1, 2, 3, 1), 10));
	}
}
