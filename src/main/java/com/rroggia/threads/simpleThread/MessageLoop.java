package com.rroggia.threads.simpleThread;

public class MessageLoop implements Runnable {

	@Override
	public void run() {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };
		try {
			for (int i = 0; i < importantInfo.length; i++) {
				Thread.sleep(4000);
				getMessage(importantInfo[i]);
			}
		} catch (InterruptedException e) {
			getMessage("I wasn't done!");
		}

	}

	private void getMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

}
