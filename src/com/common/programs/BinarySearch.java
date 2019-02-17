package com.common.programs;

public class BinarySearch
{
    int ar[];


    public BinarySearch(int[] ar)
    {
        this.ar = ar;
    }


    private int find(int low, int high, int el)
    {
        if (high >= low)
        {
            int mid = low + (high - low) / 2;
            if (el == ar[mid])
            {
                return mid + 1;
            }

            if (el > ar[mid])
            {
                return find(mid + 1, high, el);
            }
            else if (el < ar[mid])
            {
                return find(0, mid - 1, el);
            }
        }
        return -1;
    }


    public static void main(String[] args)
    {
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch bs = new BinarySearch(ar);
        int pos = bs.find(0, ar.length - 1, 9);
        if (pos < 0)
            System.out.println("Element not found.");
        else
            System.out.println("Element found @ pos: " + pos);
    }

}
