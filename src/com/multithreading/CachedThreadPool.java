package com.multithreading;

import com.multithreading.tasks.TaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
