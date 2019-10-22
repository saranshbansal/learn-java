package com.algos.sort;

public class Practice
{
    int arr[] = {1, 5, 7, 9, 4, 9, 0, 30, 6};


    void bbSort()
    {
        for (int i = 0; i < arr.length; i++)
        {
            boolean flg = false;
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j + 1] < arr[j])
                {
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
        for (int k = 0; k < arr.length; k++)
        {
            System.out.println(arr[k]);
        }
    }


    void insSort()
    {
        for (int i = 1; i < arr.length; i++)
        {
            int j = i - 1;
            while (j > 0 && arr[i] < arr[j])
            {
                arr[j + 1] = arr[j]; // shift all els
                j--;
            }

            arr[j + 1] = arr[i]; // assign el to correct index

        }

        // display
        for (int k = 0; k < arr.length; k++)
        {
            System.out.println(arr[k]);
        }
    }


    void selSort()
    {
        for (int i = 0; i < arr.length; i++)
        {
            int temp_min_idx = i;
            int true_min_idx = i;

            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[i])
                {
                    true_min_idx = j;
                }
            }

            int temp = arr[temp_min_idx];
            arr[temp_min_idx] = arr[true_min_idx];
            arr[true_min_idx] = temp;
        }

        // display
        for (int k = 0; k < arr.length; k++)
        {
            System.out.println(arr[k]);
        }
    }


    public static void main(String[] args)
    {
        Practice p = new Practice();
        // adjacent els
        p.bbSort();

        // shifting
        p.insSort();

        // true minimum
        p.selSort();
    }
}
