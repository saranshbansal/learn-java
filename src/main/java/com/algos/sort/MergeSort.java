package com.algos.sort;

import java.util.Arrays;

/*
 * <Note on java.lang.System.arraycopy();>
 *
 * The java.lang.System.arraycopy() method copies an array from the specified
 * source array, beginning at the specified position, to the specified position
 * of the destination array. A subsequence of array components are copied from
 * the source array referenced by src to the destination array referenced by
 * dest.The number of components copied is equal to the length argument.
 *
 * The components at positions srcPos through srcPos + length - 1 in the source
 * array are copied into positions destPos through destPos + length - 1,
 * respectively, of the destination array.
 *
 * <Parameters>
 * src - This is the source array.
 * srcPos - This is the starting position in the source array.
 * dest - This is the destination array.
 * destPos - This is the starting position in the destination data.
 * length - This is the number of array elements to be copied.
 */

/**
 * In computer science, merge sort (also commonly spelled mergesort) is an
 * O(nlog n) and it needs Ο(n) auxiliary space. divide n conquer sorting algorithm.
 * Most implementations produce a
 * stable sort, which means that the implementation preserves the input order of
 * equal elements in the sorted output. Mergesort is a divide and conquer
 * algorithm. Divide and conquer algorithms divide the original data into
 * smaller sets of data to solve the problem.
 * <p>
 * During the Mergesort process the object in the collection are divided into
 * two collections. To split a collection, Mergesort will take the middle of the
 * collection and split the collection into its left and its right part. The
 * resulting collections are again recursively splitted via the Mergesort
 * algorithm until they are broke to single element in each collection.
 * <p>
 * After splitting each collection, mergesort algorithm start combining all
 * collections obtained via above procedure. To combine both collections
 * Mergesort start at each collection at the beginning. It pick the object which
 * is smaller and inserts this object into the new collection. For this
 * collection it now selects the next elements and selects the smaller element
 * from both collection by comparing one element from each collection at a time.
 * <p>
 * This process create a collection of sorted elements (subset of all elements
 * which needs to be sorted). This process is recursively done for all available
 * collections obtained in first step i.e. splitting the collections.
 * <p>
 * Once all elements from both collections have been inserted in the new
 * collection, Mergesort has successfully sorted the collection.
 * <p>
 * <When to use Merge Sort>
 * 1. Merge sort is used when the data structure doesn�t support random access,
 * since it works with pure sequential access (forward iterators, rather than
 * random access iterators). It�s also widely used for external sorting, where
 * random access can be very, very expensive compared to sequential access.
 * For example, When sorting a file which doesn�t fit into memory, you might
 * break it into chunks which fit into memory, sort these chunks independently,
 * writing each out to a file, then merge sort the generated files.
 * 2. Also, you can use merge sort when you need a stable sort. It�s very important
 * feature of merge sort.
 * 3. Mergesort is quicker when dealing with linked lists. This is because pointers
 * can easily be changed when merging lists. It only requires one pass (O(n)) through
 * the list.
 * 4. If there is a lot of parallelization occurs then parallelizing Mergesort is
 * simpler than other sort algorithms.
 *
 *
 * <Steps>
 * 1. Divide the unsorted list into two sublists of about half the size.
 * 2. Sort each of the two sublists.
 * 3. Merge the two sorted sublists back into one sorted list.
 */
public class MergeSort {
    public static void main(String[] args) {
        // Unsorted array
        int[] a = {2, 6, 3, 5, 1, 4};

        // Call merge sort
        mergeSort(a);

        // Check the output which is sorted array
        System.out.println(Arrays.toString(a));
    }


    /**
     * @param list
     * @return
     */
    public static int[] mergeSort(int[] list) {
        // If list is empty; no need to do anything
        if (list.length <= 1) {
            return list;
        }

        // Create 2 lists to hold 1st half and 2nd half of original list.
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];

        // Split the array in half and populate above lists.
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        // Merge both halves together, overwriting original array
        merge(first, second, list);
        return list;
    }


    /**
     * @param first
     * @param second
     * @param result
     */
    private static void merge(int[] first, int[] second, int[] result) {
        // Index Position in first array - starting with first element
        int iFirst = 0;

        // Index Position in second array - starting with first element
        int iSecond = 0;

        // Index Position in merged array - starting with first position
        int iMerged = 0;

        // Compare elements at iFirst and iSecond,
        // and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        // copy remaining elements from both halves - each half will have already sorted
        // elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
