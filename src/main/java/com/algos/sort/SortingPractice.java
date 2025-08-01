package com.algos.sort;

import java.util.Arrays;

/**
 * Sorting algorithms in java
 * <p>
 * Created by sbansal on 2/16/17.
 */
public class SortingPractice {
    static int[] arr = {1, 5, 7, 9, 4, 9, 0, 30, 6};


    public static void main(String[] args) {
        SortingPractice p = new SortingPractice();
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println();

        // bb sort - adjacent els
        int[] arr1 = arr.clone();
        p.bbSort(arr1);
        System.out.println(' ');

        // ins sort - shifting
        int[] arr2 = arr.clone();
        p.insSort(arr2);
        System.out.println(' ');

        // selection sort - true minimum
        int[] arr3 = arr.clone();
        p.selSort(arr3);
        System.out.println(' ');

        // quick sort - pi and recursive sort
        int[] arr4 = arr.clone();
        p.quickSort(arr4, 0, arr4.length - 1);
        System.out.print("QUICK SORT:" + Arrays.toString(arr4));
        System.out.println(' ');

        // heap sort - build max heap
        int[] arr5 = arr.clone();
        p.heapSort(arr5);
        System.out.println(' ');
    }


    // Trick: Compare adjacent elements
    void bbSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flg = true;
                }
            }

            if (!flg)
                break;

        }

        // display
        System.out.print("BB SORT:" + Arrays.toString(arr));
    }

    // compare to all elements left to current element
    void insSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int j = i - 1;
            while (j >= 0 && currentElement < arr[j]) {
                arr[j + 1] = arr[j]; // shift all els
                j--;
            }

            arr[j + 1] = currentElement; // assign el to correct index
        }

        // display
        System.out.print("INSERTION SORT:" + Arrays.toString(arr));
    }

    // compare to all elements right to current element
    void selSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int trueMinIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[trueMinIdx]) {
                    trueMinIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[trueMinIdx];
            arr[trueMinIdx] = temp;
        }

        // display
        System.out.print("SELECTION SORT:" + Arrays.toString(arr));
    }

    void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pi = partition(arr, begin, end);

            quickSort(arr, begin, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

    private void heapSort(int[] arr) {
        buildMaximumHeap(arr);

        int heapSize = arr.length - 1;
        for (int lastPosition = heapSize; lastPosition > 0; lastPosition--) {
            int temp = arr[lastPosition];
            arr[lastPosition] = arr[0];
            arr[0] = temp;

            heapSize--;

            bubbleDown(arr, 0, heapSize);
        }

        // display
        System.out.print("HEAP SORT:" + Arrays.toString(arr));
    }

    private void buildMaximumHeap(int[] arr) {
        int lastParent = (arr.length - 1) / 2;

        for (int i = lastParent; i >= 0; i--) {
            bubbleDown(arr, i, arr.length - 1);
        }
    }

    private void bubbleDown(int[] arr, int parentIndex, int heapBoundary) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int largestElementIndex;

        if (leftChildIndex <= heapBoundary && arr[leftChildIndex] > arr[parentIndex]) {
            largestElementIndex = leftChildIndex;
        } else {
            largestElementIndex = parentIndex;
        }

        if (rightChildIndex <= heapBoundary && arr[rightChildIndex] > arr[largestElementIndex]) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != parentIndex) {
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[largestElementIndex];
            arr[largestElementIndex] = temp;

            bubbleDown(arr, largestElementIndex, heapBoundary);
        }
    }
}
