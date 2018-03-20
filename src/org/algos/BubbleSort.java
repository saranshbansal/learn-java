package org.algos;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {1,5,7,9,4,0,0,0,6};
		int temp;
		for (int i = 0; i < a.length; i++) {
			boolean flg = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1]=temp;
					flg = true;
				}
			}
			if(!flg) {
				break;
			}
		}

		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
	}
}
