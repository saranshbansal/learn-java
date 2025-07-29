package com.algos.sort;

import java.util.Arrays;

/**
 * A simple implementation of Bubble Sort algorithm.
 * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in wrong order.
 * The pass through the list is repeated until the list is sorted.
 */
public class BubbleSort {
    public static void main(String[] args) {
        // Input array to be sorted
        int[] numbers = {1, 5, 7, 9, 4, 0, 0, 0, 6};
        System.out.println("Original array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("\nSorted array:" + Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;

        // Outer loop for each pass through the array
        for (int pass = 0; pass < n - 1; pass++) {
            // Flag to check if any swap happened in this pass
            boolean swapped = false;

            // Inner loop for comparing adjacent elements
            for (int currentIndex = 0; currentIndex < n - 1 - pass; currentIndex++) {
                // If current element is greater than next element, swap them
                if (arr[currentIndex] > arr[currentIndex + 1]) {
                    // Swap elements
                    swap(arr, currentIndex, currentIndex + 1);
                    swapped = true;
                }
            }

            // If no two elements were swapped in inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
