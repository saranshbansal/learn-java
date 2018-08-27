package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.multithreading.tasks.TaskA;

public class FixedThreadPool
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(new TaskA());
        executorService.submit(new TaskA());
        executorService.submit(new TaskA());

        executorService.submit(new TaskA());
        executorService.submit(new TaskA());
        executorService.submit(new TaskA());

        executorService.shutdown(); // imp to shutdown
        System.out.println("after shutdown");
        try
        {
            System.out.println("after shutdown");
            executorService.awaitTermination(1, TimeUnit.MICROSECONDS);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
