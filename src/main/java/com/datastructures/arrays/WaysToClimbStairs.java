package com.datastructures.arrays;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * To calculate the number of ways to climb the stairs, we can observe that when we are on the nth stair,
 * we have two options:
 * 1. either we climbed one stair from the (n-1)th stair or
 * 2. we climbed two stairs from the (n-2)th stair.
 * By leveraging this observation, we can break down the problem into smaller subproblems and apply the concept of the Fibonacci series.
 */
public class WaysToClimbStairs {
    public static void main(String[] args) {
        WaysToClimbStairs waysToClimbStairs = new WaysToClimbStairs();
        System.out.println(waysToClimbStairs.climbStairsDp(5));
        System.out.println(waysToClimbStairs.climbStairsRecursion(5));
    }

    public int climbStairsRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    public int climbStairsDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
