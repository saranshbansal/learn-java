package com.multithreading;

public class Test {
	public int count;

	/**
	 * Use of synchronized to avoid corrupt result in case of thread-interleaving
	 */
	public synchronized void increment() {
		count++;
	}

	private void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
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
		Test t = new Test();
		try {
			t.doWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
