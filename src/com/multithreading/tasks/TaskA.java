package com.multithreading.tasks;

import java.util.concurrent.TimeUnit;

public class TaskA implements Runnable {
	private static int count = 0;
	private int id;
	
	public TaskA() {
		this.id = ++count;
	}
	
	@Override
	public void run() {
		System.out.println("<<<< TASK-" + id + " STARTING >>>>");
		for (int i = 10; i > 0; i--) {
			System.out.println("TASK-" + id + " TICK TICK " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		System.out.println("<<<< TASK-" + id + " FINISHED >>>>");
	}

}
