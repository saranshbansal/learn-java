package com.datastructures.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description
 *
 * To break it down:
 *
 * - The method is using binary search to efficiently find the maximum sum of candy prices that is less than or equal to k.
 * - It maintains low and high indices to define the search space, starting from 0 to the length of the prices array.
 * - At each step, it calculates the mid index and checks if the count of candies chosen so far (by summing prices up to mid) is >= k.
 * - If count >= k, it means the solution lies on the left side of mid. So it updates low to mid+1.
 * - If count < k, the solution lies on the right side of mid. So it updates high to mid-1.
 * - This process of dividing the search space in half continues until low and high cross, leaving high pointing to the maximum index.
 * - The price at this index represents the maximum sum that is <= k.
 *
 * So in summary, the final value of high is returned because the binary search algorithm has determined that to be the optimal
 * index/solution within the candy prices array.
 */
public class MaximumTastinessOfCandyBasket {
	public int maximumTastiness(int[] price, int k) {
		int n = price.length;
		Arrays.sort(price);
		int low = 0;
		int high = price[n - 1] - price[0];
		while (low <= high) {
			int mid = (low + high) / 2;
			int count = 1;
			int last = price[0];
			for (int i = 1; i < n; i++) {
				if (price[i] - last >= mid) {
					count++;
					last = price[i];
				}
			}
			if (count >= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}

	public static void main(String[] args) {
		MaximumTastinessOfCandyBasket m = new MaximumTastinessOfCandyBasket();
		int[] price = {13, 5, 1, 8, 21, 2};
		System.out.println(m.maximumTastiness(price, 3));
	}
}