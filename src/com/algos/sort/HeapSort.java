package com.algos.sort;

import java.util.Arrays;

/**
 * 
 * <What is heap?> 
 * A heap is a tree with some special properties, so value of
 * node should be greater than or equal to(less than or equal to in case of min
 * heap) children of the node and tree should be complete binary tree.
 * 
 * <Binary heaps> 
 * Binary heaps are those heaps which can have up to 2 children.
 * 
 * <Understanding complete binary tree> 
 * Complete binary tree is a binary tree whose leaves are at h or h-1 level where 
 * h is height of the tree. 
 * 
 * Index of left child= 2*(index of its parent)+1 
 * Index of right child= 2*(index of its parent)+2
 * 
 * <Steps for heap sort> 
 * 1. Represent array as complete binary tree. 
 * Left child will be at 2*i+1 th location 
 * Right child will be at 2*i+2 th location. 
 * 
 * 2.Build a heap. 
 * - All the leaf nodes already satisfy heap property, so we
 * don�t need to heapify them. 
 * - Last leaf node will be present at (n-1)th location, so parent of it will 
 * be at (n-1)/2 th location, hence (n-1)/2 will be location of last non leaf node. 
 * - Iterate over non leaf nodes and heapify the elements. 
 * 
 * 3. After building a heap, max element will be at root of the heap.
 * We will exchange it with (n-1)th location, so largest element will be at
 * proper place and remove it from the heap by reducing size of n. 
 * 
 * 4. When you exchange largest element, it may disturb max heap property, 
 * so you need to again heapify it. 
 * 
 * 5. Once you do above steps until no elements left in heap, you will get sorted 
 * array in the end.
 *
 */
public class HeapSort
{
    public static void main(String[] args)
    {
        int[] arr = {3, 4, 2, 6, 7, 1, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static int[] heapSort(int[] arr)
    {
        buildHeap(arr);
        // below is the trickiest part. read 3rd step
        int sizeOfHeap = arr.length - 1;
        for (int i = sizeOfHeap; i > 0; i--)
        {
            swap(arr, 0, i);
            sizeOfHeap--;
            heapify(arr, 0, sizeOfHeap);
        }
        return arr;
    }


    private static void buildHeap(int[] arr)
    {
        for (int i = (arr.length - 1) / 2; i >= 0; i--)
        {
            heapify(arr, i, arr.length - 1);
        }
    }


    private static void heapify(int[] arr, int i, int size)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max;

        if (left <= size && arr[left] > arr[i])
        {
            max = left;
        }
        else
        {
            max = i;
        }
        if (right <= size && arr[right] > arr[max])
        {
            max = right;
        }
        if (max != i)
        {
            swap(arr, i, max);
            heapify(arr, max, size);
        }

    }


    private static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
