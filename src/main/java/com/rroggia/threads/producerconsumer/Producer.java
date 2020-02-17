package com.rroggia.threads.producerconsumer;

import java.util.Random;

public class Producer implements Runnable {

	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		String importantMessages[] = { "Mares eat oats", "Does eats oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		Random random = new Random();

		for (int i = 0; i < importantMessages.length; i++) {
			drop.put(importantMessages[i]);

			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		drop.put("DONE");

	}

}
