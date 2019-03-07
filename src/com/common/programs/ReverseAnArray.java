package com.common.programs;

import java.util.Arrays;

public class ReverseAnArray
{

    private void reverse(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // for print purpose.
        Arrays.stream(arr).forEach(obj -> System.out.println(obj));
    }


    public static void main(String[] args)
    {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int arr[] = {1, 3, 2, 3, 4, 5};
        reverseAnArray.reverse(arr);
    }
}
