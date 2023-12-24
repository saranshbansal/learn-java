package com.miscellaneous;

import java.util.Arrays;

/**
 * @author sbansal 0h 28m Java
 * <p>
 * 1 Task description This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive
 * integer (greater than 0) that does not occur in A.
 * <p>
 * For example,
 * Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000]; each element of array
 * A is an integer within the range [−1,000,000..1,000,000]. Complexity:
 * <p>
 * expected worst-case time complexity is O(N); expected worst-case
 * space complexity is O(N), beyond input storage (not counting the
 * storage required for input arguments).
 */
public class SmallestPositive {

	public static void main(String[] args) {
		int[] arr = {-1, -3};
		Arrays.sort(arr);
		System.out.println(findSmallestPositive(arr));
	}


	private static int findSmallestPositive(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			// No next smallest missing element found within array. Return the next highest integer.
			if (i == n - 1) {
				return (arr[n - 1] + 1 > 0 ? arr[n - 1] + 1 : 1);
			}
			// Otherwise, continue.
			if ((i < n - 1) && (arr[i + 1] - arr[i] > 1) && (arr[i] + 1 > 0)) {
				return arr[i] + 1;
			}
		}
		return -1;
	}
}
