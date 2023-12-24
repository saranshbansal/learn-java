package com.miscellaneous;

import java.io.IOException;

public class CoPrimePairs {

	// return gcd of a and b
	static int gcd(int a, int b) {
		// Everything divides 0
		if (a == 0 || b == 0)
			return 0;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a - b, b);

		return gcd(a, b - a);
	}


	// function to check for co-prime
	static boolean coprime(int a, int b) {
		return (gcd(a, b) == 1);
	}


	// Returns count of co-prime pairs present in array
	static int numOfPairs(int arr[]) {
		int n = arr.length;

		int count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (coprime(arr[i], arr[j]))
					count++;

		return count;
	}


	static int saveBatman(int runwayLen, int numRunways) {
		int[] arr = new int[numRunways];
		for (int i = 0; i < numRunways; i++) {
			arr[i] = i + 1;
		}
		return numOfPairs(arr);
	}


	public static void main(String args[])
			throws IOException {
		int m = 1000000007;

		int result = saveBatman(2, 3);
		int modResult = (result % m + m) % m;

		System.out.println(modResult);
	}
}
