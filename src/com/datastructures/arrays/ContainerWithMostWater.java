package com.datastructures.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * Explanation
 *
 * - To start, we place both pointers at the beginning and end of the array.
 * While this is common with most two pointer approaches, in this specific problem it allows us to consider all potential possibilities.
 * Thus, in a way we are still brute forcing the solution, however we are carefully optimizing the possibilities at each
 * iteration so that the optimal solution is not missed.
 * - At each iteration, no matter what, the width will decrease. This is because we must move either the left and right pointer.
 * Therefore, we must consider the potential outcomes after we either increase the left pointer or decrease the right pointer.
 * 		Outcome A: If we decrease a pointer and the height of the pillar is smaller than the previous height (where the pointer was originally before we moved it), the overall area will have to be smaller. This is because we take the minumum of the two heights that the pointers are pointing at, and because the width will be decreased by 1, the new area will have to be the same or smaller.
 * 		Outcome B: If we decrease a pointer and the height of the pillar is larger or the same as the previous height, the width may or may not be larger than the previous height, because it depends on whether the height difference between the new pillar and the previous pillar can compensate for the loss of width.
 *
 * So why do we always move the pointer of the smallest pillar?
 *
 * The reason for this is simple.
 * There is no reason to hang onto the pillar of the smallest size in the current range because in the next iteration,
 * the overall width will decrease by one. Thus, a potential greater area will never be reached by hanging onto the smaller pillar,
 * because even if another taller pillar is found by moving the pointer at the taller pillar, the area must always be
 * calculated with the minimum of the two pillars. Due to the smaller width by decreasing the pointer range, the overall area
 * will be smaller regardless. Thus, we can safely disregard the smaller pillar at each iteration.
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
