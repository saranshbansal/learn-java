package com.miscellaneous;

import java.util.HashMap;

/*
 * A Java program to find all symmetric pairs in a given array of pairs:
 *
 * Two pairs (a, b) and (c, d) are said to be symmetric if b is equal to d and a is equal to d.
 * For example (10, 20) and (20, 10) are symmetric. Given an array of pairs find all symmetric pairs in it.
 */
class SymmetricPairsIn2DArray {

	// Print all pairs that have a symmetric counterpart
	static void findSymPairs(int arr[][]) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// First and second elements of current pair
			int first = arr[i][0];
			int sec = arr[i][1];

			// Look for second element of this pair in hash
			Integer val = hm.get(sec);

			// If found and value in hash matches with first
			// element of this pair, we found symmetry
			if (val != null && val == first)
				System.out.println("(" + sec + ", " + first + ")");

			else // Else put sec element of this pair in hash
				hm.put(first, sec);
		}
	}


	// Drive method
	public static void main(String arg[]) {
		int arr[][] = new int[5][2];
		arr[0][0] = 11;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		arr[2][0] = 5;
		arr[2][1] = 10;
		arr[3][0] = 40;
		arr[3][1] = 30;
		arr[4][0] = 10;
		arr[4][1] = 5;
		findSymPairs(arr);
	}
}
