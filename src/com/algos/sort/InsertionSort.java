package com.algos.sort;

import java.util.Arrays;

/**
 * Imagine sorting through a deck of cards. In each pass, the current card is
 * compared to all previous cards.
 * 
 */
public class InsertionSort {
	public static void main(String[] args) {
		int a[] = { 1, 0, 7, 5, 8, 3, -3 };
		System.out.println("Original array: " + Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			int currentElement = a[i];
			int j = i - 1;
			System.out.println("current element {" + currentElement + "} comparison with {" + a[j] + "}");
			while (j >= 0 && currentElement < a[j]) {
				// tricky part! shift left n right elements as current element (being smaller)
				// is added between them.
				a[j + 1] = a[j];
				j--;
			}
			System.out.println("new position of current element: " + (j + 1));
			a[j + 1] = currentElement; // trickiest part! set current element into the right place ie. at j+1.
			System.out.println("Pass " + i + ". " + Arrays.toString(a));
		}

	}
}
