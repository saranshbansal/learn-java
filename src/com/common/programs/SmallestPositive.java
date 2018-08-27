package com.common.programs;

import java.util.Arrays;

/**
 * @author sbansal 0h 28m Java
 * 
 *         1 Task description This is a demo task.
 * 
 *         Write a function:
 * 
 *         class Solution { public int solution(int[] A); }
 * 
 *         that, given an array A of N integers, returns the smallest positive
 *         integer (greater than 0) that does not occur in A.
 * 
 *         For example, given A = [1, 3, 6, 4, 1, 2], the function should return
 *         5.
 * 
 *         Given A = [1, 2, 3], the function should return 4.
 * 
 *         Given A = [−1, −3], the function should return 1.
 * 
 *         Assume that:
 * 
 *         N is an integer within the range [1..100,000]; each element of array
 *         A is an integer within the range [−1,000,000..1,000,000]. Complexity:
 * 
 *         expected worst-case time complexity is O(N); expected worst-case
 *         space complexity is O(N), beyond input storage (not counting the
 *         storage required for input arguments). Copyright 2009–2018 by
 *         Codility Limited. All Rights Reserved. Unauthorized copying,
 *         publication or disclosure prohibited. Solution Solution Java SE 8
 * 
 *         Run Tests
 * 
 *         Submit
 * 
 * 
 *         You will see save status here Test Output Test Output
 * 
 */
public class SmallestPositive
{

    public static void main(String[] args)
    {
        int[] arr = {-3, 1, 2, 3, 5, 8};
        Arrays.sort(arr);
        System.out.println(findSmallestPositive(arr));
    }


    private static int findSmallestPositive(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            // No next smallest missing element found within array. Return the next highest integer.
            if (i == arr.length - 1)
            {
                return arr[i] + 1;
            }
            // Otherwise, continue.
            if ((i < arr.length - 1) && (arr[i + 1] - arr[i] > 1) && (arr[i] + 1 > 0))
            {
                return arr[i] + 1;
            }
        }
        return -1;
    }
}
