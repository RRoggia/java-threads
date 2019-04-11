package com.rroggia.thread.exercise.three;

public class Exercise3 {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {

			long threadId = Thread.currentThread().getId();

			try {
				System.out.println("Thread " + threadId + " is going to sleep");
				Thread.sleep(600000);
			} catch (InterruptedException e) {
				System.out.println("Thread " + threadId + " was interrupted ");
				return;
			}
			System.out.println("Thread" + threadId + " woke up");
		});

		System.out.println("Thread " + thread.getId() + " is created.");

		thread.start();
		System.out.println("Thread " + thread.getId() + " is started.");

		thread.interrupt();
		System.out.println("Thread " + thread.getId() + " is interrupted.");
	}

}
