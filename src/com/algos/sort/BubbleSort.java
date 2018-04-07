package com.algos.sort;

/**
 * ALL Left n right elements are compared in each n passes where
 * n is length of array.
 */
public class BubbleSort {
	public static void main(String[] args) {
		int a[] = { 1, 5, 7, 9, 4, 0, 0, 0, 6 };
		int temp;
		for (int i = 0; i < a.length; i++) { // n-passes
			boolean flg = false;
			for (int j = 0; j < a.length - i - 1; j++) { // ith pass
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flg = true;
				}
			}
			if (!flg) {
				break;
			}
		}

		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
	}
}
