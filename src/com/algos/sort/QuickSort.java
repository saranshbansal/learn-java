package com.algos.sort;

import java.util.Arrays;

/* Java program for implementation of QuickSort (D&C algo)
https://www.youtube.com/watch?v=7h1s2SojIRw
Base idea: All elements to left are smaller than all elements to the right 
then the element is said to be in 'sorted' position.
Time: O(n log n) 
Space: O(log(n)) 

Algo:
// partition
partition(l,h) {
    pivot = A[l];
    i=l; j=h;
    
    while(i<j) {
        // avoid iterating over pivot itself
        i += 1;
        
        do {
            i++;
        } while(i <= high && A[i]<pivot);
        
        do {
            j--;
        } while(j >= low && A[j]>pivot);
        
        if(i<j) {
            swap(A[i], A[j]);
        }
    }
    
    swap(A[l], A[j]);
    
    return j;
}

// quicksort
QuickSort(l,h) {
    pi = partition(l, h);
    QuickSort(l, pi-1);
    QuickSort(pi+1, h);
}
*/
public class QuickSort {

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7};

		new QuickSort().sort(arr, 0, arr.length - 1);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	/**
	 * Quick sort the given array starting from index
	 * {@code l} to {@code r}
	 * <p>
	 * Uses the first element in the array as the pivot
	 *
	 * @param array
	 * @param low
	 * @param high
	 */
	private int partition(int[] array, int low, int high) {
		// select pivot element (left-most)
		int pivot = array[low];
		int i = low;
		int j = high;

		// partition and shuffle around pivot
		while (i < j) {
			// move right to avoid pivot element
			i++;
			// scan left: find elements smaller than pivot
			while (i <= high && array[i] < pivot) {
				i++;
			}
			// scan right: find elements greater than pivot
			while (j >= low && array[j] > pivot) {
				j--;
			}
			if (i <= high && i < j) {
				// swap around pivot
				swap(array, i, j);
			}
		}
		// last step to put pivot (or low) in correct place
		swap(array, low, j);
		return j;
	}

	/**
	 * Quick sort the given array in ascending order
	 *
	 * @param array
	 */
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
			int pi = partition(arr, low, high);

			// Recursively sort elements before partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	/**
	 * Swap elements at indexes {@code i} and {@code j}
	 * in the give array
	 *
	 * @param array
	 * @param i
	 * @param j
	 */
	private void swap(int[] array, int i, int j) {
		if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}

}
