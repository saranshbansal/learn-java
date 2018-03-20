package org.algos;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int a[] = { 1, 0, 7, 5, 8, 3, -3 };
		System.out.println("Original array: " + Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && key < a[j]) {
				// shift elements before key by 1 ahead
				a[j + 1] = a[j]; // tricky part
				j--;
			}
			System.out.println("Pass " + i + ". j = " + j + ", element {" + key + "} at pos: " + (j + 1));
			a[j + 1] = key; // trickiest part (imagine everything in terms of j. i is not important)
			System.out.println(Arrays.toString(a));
		}

	}
}
