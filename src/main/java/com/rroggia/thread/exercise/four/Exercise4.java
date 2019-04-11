package com.rroggia.thread.exercise.four;

public class Exercise4 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			long threadId = Thread.currentThread().getId();

			System.out.println("Thread " + threadId + " started its execution.");

			while (!Thread.interrupted())
				;

			System.out.println("Thread " + threadId + " was interrupted.");
			return;
		});
		System.out.println("Thread " + thread.getId() + " is created.");

		thread.start();
		System.out.println("Thread " + thread.getId() + " is started.");

		Thread.sleep(10000);

		thread.interrupt();
		System.out.println("Thread " + thread.getId() + " is interrupted.");
	}

}
