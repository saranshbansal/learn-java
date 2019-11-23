package com.multithreading;

import java.util.concurrent.TimeUnit;

public class DeadLock
{
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();


    public static void main(String args[])
    {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock1)
                {
                    System.out.println("Thread1 acquired lock1");
                    try
                    {
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                    catch (InterruptedException ignore)
                    {}
                    synchronized (lock2)
                    {
                        System.out.println("Thread1 acquired lock2");
                    }
                }
            }

        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock2)
                {
                    System.out.println("Thread2 acquired lock2");
                    synchronized (lock1)
                    {
                        System.out.println("Thread2 acquired lock1");
                    }
                }
            }
        });
        thread2.start();
    }

}
