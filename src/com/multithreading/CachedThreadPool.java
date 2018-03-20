package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.multithreading.tasks.TaskA;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new TaskA());
		executorService.submit(new TaskA());
		executorService.submit(new TaskA());
		
		executorService.submit(new TaskA());
		executorService.submit(new TaskA());
		executorService.submit(new TaskA());
		
		executorService.shutdown(); // imp to shutdown
	}
}
