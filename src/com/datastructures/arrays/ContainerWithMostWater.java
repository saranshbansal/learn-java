package com.datastructures.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * The proof of why the solution works is important to understand. Following is its summary:
 *
 * - Consider we start with i = 0 and j = height.size() - 1. That is, i points to the first column and j points to the last column.
 * - Now suppose that h(i)>h(j) (we are not loosing generality by this assumption)
 * - We calculate the water capacity for the i, j. It will be h(j)*(j-i).
 * - Now see that if we fix j at height.size() - 1 and vary i, we cannot get a greater water capacity. Why?
 * 		capacity = min of both heights * width between them. Since capacity is the product of these two terms, we will look at each term individually.
 * 		First about the width. It is easy to see that for all other i's (i = 1, 2,... ,height.size()-2) we will have a lesser width.
 * 		Second, the height will be the minimum of the column at i and at j, i.e. min(h(i),h(j)). But this value will be always less than h(j)
 * 		So both factors in the calculation of the capacity will be smaller and hence we can skip considering all the cases where i = 1, 2, 3, ..., height.size()-2 and j = height.size()-1
 * 		Which basically means that we can simply move j to j-1.
 *
 * This is how I understood it and I hope this explanation makes it easy to understand.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(maxArea, area);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(cwmw.maxArea(height));
	}
}
