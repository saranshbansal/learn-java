package com.algos.sort;

import java.util.Arrays;

/**
 * QuickSort Implementation - First Element as Pivot Strategy
 * 
 * This implementation of QuickSort uses the FIRST element as the pivot, which is
 * different from the more common last-element approach. This demonstrates an
 * alternative partitioning strategy in the QuickSort algorithm.
 * 
 * Algorithm Overview:
 * 1. Choose the first element as pivot
 * 2. Partition array so elements < pivot are on left, elements > pivot are on right
 * 3. Recursively sort the left and right sub-arrays
 * 
 * Time Complexity:
 * - Best Case: O(n log n) - when pivot divides array into roughly equal halves
 * - Average Case: O(n log n) - expected performance with random data
 * - Worst Case: O(n²) - when array is already sorted or reverse sorted
 * 
 * Space Complexity: O(log n) - due to recursive call stack in average case
 * 
 * @author DSA Cookbook
 * @version 1.0 (First Element Pivot Strategy)
 */
public class QuickSortTwoPointer {

    /**
     * Main method to demonstrate QuickSort algorithm with first element as pivot
     */
    public static void main(String[] args) {
        // Test array with various elements including duplicates
        int[] arr = {14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        QuickSortTwoPointer sorter = new QuickSortTwoPointer();
        sorter.quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    /**
     * Main QuickSort method that recursively sorts the array using first element as pivot
     * 
     * @param arr  The array to be sorted
     * @param low  Starting index of the portion to sort
     * @param high Ending index of the portion to sort
     */
    public void quickSort(int[] arr, int low, int high) {
        // Base case: if low >= high, the sub-array has 0 or 1 element (already sorted)
        if (low < high) {
            // Partition the array using first element as pivot and get the pivot's final position
            // After partitioning:
            // - All elements left of pivotIndex are <= pivot
            // - All elements right of pivotIndex are >= pivot
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort the left sub-array (elements before pivot)
            quickSort(arr, low, pivotIndex - 1);
            
            // Recursively sort the right sub-array (elements after pivot)
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array using the FIRST element as pivot (Lomuto-style with first element)
     * 
     * This method uses a two-pointer approach:
     * - Left pointer (i) moves right to find elements >= pivot
     * - Right pointer (j) moves left to find elements <= pivot
     * - When both pointers find their targets, elements are swapped
     * - Finally, pivot is placed in its correct sorted position
     * 
     * @param array The array to partition
     * @param low   Starting index of the range to partition
     * @param high  Ending index of the range to partition
     * @return The final index position of the pivot element
     */
    private int partition(int[] array, int low, int high) {
        // Choose the FIRST element as pivot
        int pivot = array[low];
        
        // Initialize two pointers
        int leftPointer = low;      // Will scan from left to right
        int rightPointer = high;    // Will scan from right to left
        
        // Continue until pointers meet
        while (leftPointer < rightPointer) {
            // Move left pointer to skip the pivot element initially
            leftPointer++;
            
            // Move left pointer right until we find an element >= pivot
            // (or reach the end of the range)
            while (leftPointer <= high && array[leftPointer] < pivot) {
                leftPointer++;
            }
            
            // Move right pointer left until we find an element <= pivot
            // (or reach the beginning of the range)
            while (rightPointer >= low && array[rightPointer] > pivot) {
                rightPointer--;
            }
            
            // If pointers haven't crossed and left pointer is valid, swap elements
            if (leftPointer <= high && leftPointer < rightPointer) {
                swap(array, leftPointer, rightPointer);
            }
        }
        
        // Place pivot in its correct position by swapping with element at rightPointer
        // At this point, rightPointer points to the last element <= pivot
        swap(array, low, rightPointer);
        
        // Return the final position of the pivot
        return rightPointer;
    }

    /**
     * Helper method to swap two elements in an array with bounds checking
     * 
     * @param array The array containing elements to swap
     * @param i     Index of first element
     * @param j     Index of second element
     */
    private void swap(int[] array, int i, int j) {
        // Perform bounds checking to prevent array index out of bounds
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Alternative method name for backward compatibility
     * Delegates to the main quickSort method
     * 
     * @param arr  The array to be sorted
     * @param low  Starting index
     * @param high Ending index
     */
    public void sort(int[] arr, int low, int high) {
        quickSort(arr, low, high);
    }
}
