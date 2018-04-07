package com.algos.sort;

/**
 * @author sbansal
 * Select first element as minimum and iterate through the length to find actual minimum value position then swap with first.
 */
public class SelectionSort {
	public static void main(String[] args) {
		int a[] = {64,25,12,22,11};
		for (int i = 0; i < a.length; i++) {
			int temp_min_idx = i;
			int true_min_idx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[true_min_idx]) {
					true_min_idx = j;
				}
			}
			// swap temporary/initial and actual/true minimum elements
			int temp = a[true_min_idx];
			a[true_min_idx] = a[temp_min_idx];
			a[temp_min_idx] = temp;
		}

		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
	}
}
