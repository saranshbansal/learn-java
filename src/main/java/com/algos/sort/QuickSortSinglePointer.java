package com.algos.sort;

import java.util.Arrays;

/**
 * QuickSort Implementation - A Divide and Conquer Algorithm
 * 
 * QuickSort is an efficient sorting algorithm that works by selecting a 'pivot' element
 * from the array and partitioning the other elements into two sub-arrays according to
 * whether they are less than or greater than the pivot.
 * 
 * Time Complexity:
 * - Best Case: O(n log n) - when pivot divides array into equal halves
 * - Average Case: O(n log n)
 * - Worst Case: O(n²) - when pivot is always the smallest or largest element
 * 
 * Space Complexity: O(log n) - due to recursive call stack
 */
public class QuickSortSinglePointer {

    /**
     * Main method to demonstrate QuickSort algorithm
     */
    public static void main(String[] args) {
        int[] arr = {2, 2, 6, 1, 3, 4};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        QuickSortSinglePointer sorter = new QuickSortSinglePointer();
        sorter.quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    /**
     * Main QuickSort method that recursively sorts the array
     * 
     * @param arr  The array to be sorted
     * @param low  Starting index of the portion to sort
     * @param high Ending index of the portion to sort
     */
    public void quickSort(int[] arr, int low, int high) {
        // Base case: if low >= high, the sub-array has 0 or 1 element (already sorted)
        if (low < high) {
            // Partition the array and get the pivot index
            // After partitioning:
            // - All elements left of pivotIndex are <= pivot
            // - All elements right of pivotIndex are > pivot
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort the left sub-array (elements before pivot)
            quickSort(arr, low, pivotIndex - 1);
            
            // Recursively sort the right sub-array (elements after pivot)
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element (last element in the range)
     * 
     * This method rearranges the array so that:
     * - All elements smaller than or equal to pivot are moved to the left
     * - All elements greater than pivot are moved to the right
     * - The pivot is placed in its final sorted position
     * 
     * @param arr  The array to partition
     * @param low  Starting index of the range to partition
     * @param high Ending index of the range to partition (pivot element)
     * @return The final index position of the pivot element
     */
    private int partition(int[] arr, int low, int high) {
        // Choose the last element as pivot
        int pivot = arr[high];
        
        // Index of the smaller element - indicates the right position
        // of pivot found so far
        int smallerElementIndex = low - 1;
        
        // Traverse through all elements except the pivot
        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            // If current element is smaller than or equal to pivot
            if (arr[currentIndex] <= pivot) {
                // Increment index of smaller element
                smallerElementIndex++;
                
                // Swap current element with element at smallerElementIndex
                swap(arr, smallerElementIndex, currentIndex);
            }
        }
        
        // Place pivot in its correct position by swapping with element
        // at (smallerElementIndex + 1)
        swap(arr, smallerElementIndex + 1, high);
        
        // Return the position where pivot is now located
        return smallerElementIndex + 1;
    }

    /**
     * Helper method to swap two elements in an array
     * 
     * @param arr The array containing elements to swap
     * @param i   Index of first element
     * @param j   Index of second element
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}