package com.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
	public static void main(String[] args) {
	}

	private void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			queue.put(random.nextInt(100));
		}
	}

	private void consumer() {

	}
}
