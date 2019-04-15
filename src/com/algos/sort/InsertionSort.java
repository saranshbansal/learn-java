package com.algos.sort;

import java.util.Arrays;

/**
 * Imagine sorting through a deck of cards. In each pass, the current card is
 * compared to all previous cards. O(n2)
 * The maximum number of comparisons for an insertion sort is the sum of the first integers. Again, this is O ( n 2 ) . 
 * However, in the best case, only one comparison needs to be done on each pass.
 * 
 */
public class InsertionSort
{
    public static void main(String[] args)
    {
        int a[] = {1, 0, 7, 5, 8, 3, -3};
        System.out.println("Original array: " + Arrays.toString(a));
        System.out.println(" ------------------ ");

        for (int i = 1; i < a.length; i++)
        {
            int nextElement = a[i];
            int j = i - 1; // loop over all elements at index before current element's index
            System.out.println("next element {" + nextElement + "} comparison with {" + a[j] + "} and before...");
            while (j >= 0 && nextElement < a[j])
            {
                // tricky part! shift left n right elements as current element (being smaller)
                // is added between them.
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = nextElement; // trickiest part! set current element into the right place ie. at j+1.

            System.out.println("Array after Pass " + i + ". " + Arrays.toString(a));
            System.out.println(" ------------------ ");
        }

    }
}
