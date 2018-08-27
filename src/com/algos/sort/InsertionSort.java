package com.algos.sort;

import java.util.Arrays;

/**
 * Imagine sorting through a deck of cards. In each pass, the current card is
 * compared to all previous cards.
 * 
 */
public class InsertionSort
{
    public static void main(String[] args)
    {
        int a[] = {1, 0, 7, 5, 8, 3, -3};
        System.out.println("Original array: " + Arrays.toString(a));
        for (int i = 1; i < a.length; i++)
        {
            int currentElement = a[i];
            int j = i - 1; // loop over all elements at index before current element's index
            System.out.println("current element {" + currentElement + "} comparison with {" + a[j] + "} and before...");
            while (j >= 0 && currentElement < a[j])
            {
                // tricky part! shift left n right elements as current element (being smaller)
                // is added between them.
                a[j + 1] = a[j];
                j--;
            }

            // This conditional is not required but helps understand the code better.
            if (i != (j + 1))
            {
                System.out.println("new position of current element {" + currentElement + "}: " + (j + 1));
            }
            else
            {
                System.out.println("no changes in position of current element {" + a[i] + "}");
            }

            a[j + 1] = currentElement; // trickiest part! set current element into the right place ie. at j+1.

            System.out.println("Array after Pass " + i + ". " + Arrays.toString(a));
            System.out.println(" ------------------ ");
        }

    }
}
