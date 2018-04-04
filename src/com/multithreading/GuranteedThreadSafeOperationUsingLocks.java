package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GuranteedThreadSafeOperationUsingLocks {
	public int count = 0;
	Lock lock = new ReentrantLock();

	public void increment() {
		count++;
	}

	private void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					for (int i = 0; i < 10000; i++) {
						increment();
					}
				} finally {
					lock.unlock();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					for (int i = 0; i < 10000; i++) {
						increment();
					}
				} finally {
					lock.unlock();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count: " + count);
	}

	public static void main(String[] args) {
		GuranteedThreadSafeOperationUsingLocks lockBasedOps = new GuranteedThreadSafeOperationUsingLocks();
		try {
			lockBasedOps.doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
