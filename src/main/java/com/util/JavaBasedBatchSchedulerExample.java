package com.util;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

class ReportGenerator extends TimerTask {

	@Override
	public void run() {
		System.out.println("Generating report");
	}

}


/*
 * To implement a basic scheduler in your Java application, you don't need any
 * external library. As of J2SE 1.3, Java contains the java.util.Timer and
 * java.util.TimerTask classes that can be used for this purpose. Let's first
 * make a little example that will help us describe all of the possibilities of
 * this API.
 */
public class JavaBasedBatchSchedulerExample {
	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		// Schedule to run every Sunday in midnight
		timer.schedule(new ReportGenerator(), date.getTime(), 1000 * 60 * 60 * 24 * 7);
	}
}
