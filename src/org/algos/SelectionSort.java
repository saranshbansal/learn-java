package org.algos;

public class SelectionSort {
	public static void main(String[] args) {
		int a[] = {64,25,12,22,11};
		for (int i = 0; i < a.length; i++) {
			int min_idx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min_idx]) {
					min_idx = j;
				}
			}
			// swap elements OR set ith element as min elmnt
			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}

		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
	}
}
