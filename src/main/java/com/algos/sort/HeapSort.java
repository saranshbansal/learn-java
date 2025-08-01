package com.algos.sort;

import java.util.Arrays;

/**
 * HEAP SORT - A Beginner's Guide
 *
 * Think of HeapSort like organizing a tournament bracket where the strongest player
 * always rises to the top, then we remove them and repeat until everyone is ranked.
 * The "tournament bracket" is the heap structure, "crowning champions" is extracting the maximum,
 * and "finding your level" is the heapify operation. It's a systematic way to rank everyone from strongest to weakest!
 *
 * === WHAT IS A HEAP? ===
 * A heap is like a family tree where:
 * - Parents are always stronger than their children (in a max heap)
 * - The tree is "complete" - filled from left to right, top to bottom
 * - We can represent this tree using a simple array!
 *
 * Array representation: [50, 30, 40, 10, 20, 35, 25]
 * Tree visualization:
 *         50 (index 0)
 *       /    \
 *     30(1)      40(2)
 *    / \     / \
 *   10(3)  20(4)  35(5)  25(6)
 *
 * === ARRAY TO TREE MAGIC FORMULAS ===
 * For any element at position i:
 * - Left child is at position: 2*i + 1
 * - Right child is at position: 2*i + 2
 * - Parent is at position: (i-1)/2 (floor division)
 *
 * === HOW HEAPSORT WORKS (4 SIMPLE STEPS) ===
 *
 * STEP 1: BUILD THE HEAP
 * - Start with a messy array
 * - Rearrange it so parents are bigger than children
 * - Work backwards from the last parent to the root
 *
 * STEP 2: EXTRACT THE MAXIMUM
 * - The root (position 0) is always the largest
 * - Swap it with the last element
 * - Now the largest is in its final sorted position!
 *
 * STEP 3: SHRINK THE HEAP
 * - Reduce heap size by 1 (ignore the sorted element)
 * - The new root might be out of place
 *
 * STEP 4: FIX THE HEAP (HEAPIFY)
 * - Let the new root "sink down" to its proper position
 * - Compare with children and swap with the larger child
 * - Repeat until heap property is restored
 *
 * REPEAT STEPS 2-4 until the heap is empty!
 *
 * === WHY IS THIS EFFICIENT? ===
 * - Time Complexity: O(n log n) - always consistent performance
 * - Space Complexity: O(1) - sorts in place, no extra memory needed
 * - Unlike QuickSort, it never has worst-case O(n²) performance
 *
 * === REAL WORLD ANALOGY ===
 * Imagine you're organizing a company hierarchy:
 * 1. Make sure every manager is more qualified than their subordinates
 * 2. Promote the CEO (most qualified) to the "alumni" list
 * 3. Pick a new CEO candidate and let them find their proper level
 * 4. Repeat until everyone is properly ranked
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = {50, 30, 40, 10, 20, 35, 25};
        System.out.println("Original array: " + Arrays.toString(numbers));

        heapSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }

    /**
     * Main HeapSort method - coordinates the entire sorting process
     *
     * @param array the array to be sorted
     */
    private static void heapSort(int[] array) {
        // STEP 1: Build initial max heap from unsorted array
        buildMaxHeap(array);

        // STEP 2-4: Repeatedly extract maximum and rebuild heap
        int heapSize = array.length - 1;  // Track current heap boundary

        for (int lastPosition = heapSize; lastPosition > 0; lastPosition--) {
            // STEP 2: Move largest element (root) to its final sorted position
            swapElements(array, 0, lastPosition);

            // STEP 3: Shrink heap size (exclude the sorted element)
            heapSize--;

            // STEP 4: Fix heap property - let new root find its proper place
            bubbleDownFromRoot(array, 0, heapSize);
        }
    }

    /**
     * Builds a max heap from an unsorted array
     * Works backwards from last parent to root, ensuring heap property
     *
     * @param array the array to convert into a heap
     */
    private static void buildMaxHeap(int[] array) {
        // Find the last parent node: parent of last element is at (n-1)/2
        int lastParentIndex = (array.length - 1) / 2;

        // Work backwards from last parent to root (index 0)
        // This ensures we fix heap property from bottom to top
        for (int parentIndex = lastParentIndex; parentIndex >= 0; parentIndex--) {
            bubbleDownFromRoot(array, parentIndex, array.length - 1);
        }
    }

    /**
     * Maintains heap property by moving element down to correct position
     * This is the "heapify" operation - ensures parent is larger than children
     *
     * @param array        the heap array
     * @param parentIndex  starting position to bubble down from
     * @param heapBoundary last valid index in current heap
     */
    private static void bubbleDownFromRoot(int[] array, int parentIndex, int heapBoundary) {
        // Calculate children positions using heap formulas
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int largestElementIndex;

        // Find the largest among parent and left child
        if (leftChildIndex <= heapBoundary && array[leftChildIndex] > array[parentIndex]) {
            largestElementIndex = leftChildIndex;
        } else {
            largestElementIndex = parentIndex;
        }

        // Check if right child is even larger
        if (rightChildIndex <= heapBoundary && array[rightChildIndex] > array[largestElementIndex]) {
            largestElementIndex = rightChildIndex;
        }

        // If parent is not the largest, swap and continue bubbling down
        if (largestElementIndex != parentIndex) {
            swapElements(array, parentIndex, largestElementIndex);

            // Recursively fix the affected subtree
            bubbleDownFromRoot(array, largestElementIndex, heapBoundary);
        }
    }

    /**
     * Swaps two elements in the array
     *
     * @param array       the array containing elements to swap
     * @param firstIndex  index of first element
     * @param secondIndex index of second element
     */
    private static void swapElements(int[] array, int firstIndex, int secondIndex) {
        int temporary = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temporary;
    }
}
