package com.algos.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * Comparison based algorithm: Each pair of adjacent elements are compared in each pass until array is sorted. Ο(n2)
 */
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {1, 5, 7, 9, 4, 0, 0, 0, 6};
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
