package com.common.programs;

public class NthPrimeNumber
{
    public static void main(String[] args)
    {
        System.out.println(NthPrimeNumber.find(2));
    }


    public static int find(int n)
    {
        if (n < 1)
            return 0;
        int count = 0;
        for (int i = 1; i < 100000; i++)
        {
            if (isPrime(i))
                count++;

            if (count == n)
            {
                return i;
            }
        }
        return -1;
    }


    private static boolean isPrime(int number)
    {
        if (number < 2)
            return false;
        for (int j = 2; j <= number / 2; j++)
        {
            if (number % j == 0)
                return false;
        }
        return true;
    }
}
