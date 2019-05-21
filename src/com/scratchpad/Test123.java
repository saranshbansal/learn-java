package com.scratchpad;

import java.util.Arrays;
import java.util.Scanner;

public class Test123
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++)
        {
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int count = 0;
        int i = 0;
        int loc;
        while (i < n)
        {
            count++;
            loc = x[i] + k;
            while (i < n && loc >= x[i])
                i++;
            loc = x[--i] + k;
            while (i < n && loc >= x[i])
                i++;
        }
        System.out.println(count);

    }
}
