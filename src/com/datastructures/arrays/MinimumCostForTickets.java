package com.datastructures.arrays;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets
 *
 * 983. Minimum Cost For Tickets
 *
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total, you spent $11 and covered all the days of your travel.
 */
public class MinimumCostForTickets {
	public int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];  // Find the last day of travel
		boolean[] travelDays = new boolean[lastDay + 1];  // Create array to mark travel days
		for (int day : days) {
			travelDays[day] = true;  // Mark days when travel is needed as true
		}

		int[] dp = new int[lastDay + 1];  // Stores minimum cost up to each day

		for (int i = 1; i <= lastDay; i++) {
			if (!travelDays[i]) {  // If no travel on this day
				dp[i] = dp[i - 1];  // Cost same as previous day
				continue;
			}

			// Calculate cost with different passes
			int cost1 = dp[Math.max(0, i - 1)] + costs[0];  // 1-day pass
			int cost7 = dp[Math.max(0, i - 7)] + costs[1];  // 7-day pass
			int cost30 = dp[Math.max(0, i - 30)] + costs[2];  // 30-day pass

			// Take minimum of all three options
			dp[i] = Math.min(cost1, Math.min(cost7, cost30));
		}


		return dp[lastDay];
	}

	public static void main(String[] args) {
		MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
		System.out.println(minimumCostForTickets.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
	}
}
