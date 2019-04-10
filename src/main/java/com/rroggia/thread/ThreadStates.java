package com.rroggia.thread;

public class ThreadStates {

	private static Object object = new Object();

	public static void main(String[] args) throws InterruptedException {

		demonstrateNewRunnableAndTerminatedStates();

		System.out.println();

		demonstrateTimedWaiting();

		System.out.println();

		Runnable locker = () -> {
			Thread currentThread = Thread.currentThread();
			synchronized (object) {
				System.out.println(currentThread.getId() + " is locking object");
				for (int i = 0; i < Integer.MAX_VALUE; i--)
					;
			}
		};

		Thread threadA = new Thread(locker);
		Thread threadB = new Thread(locker);
		threadA.start();
		threadB.start();
		Thread.sleep(1000);
		System.out.println(threadA.getId() + " " + threadA.getState());
		System.out.println(threadB.getId() + " " + threadB.getState());

	}

	private static void demonstrateNewRunnableAndTerminatedStates() throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("executing run() method from thread " + Thread.currentThread().getId() + ". State is "
					+ Thread.currentThread().getState());
		});
		System.out.println("Created thread " + thread.getId() + " but didn't started. State is " + thread.getState());

		thread.start();
		System.out.println("Started thread " + thread.getId() + ". State is " + thread.getState());

		Thread.sleep(10);

		System.out.println(
				"Waited 10 ms, Thread " + thread.getId() + " should have finished. State is " + thread.getState());
	}

	private static void demonstrateTimedWaiting() throws InterruptedException {
		Thread thread = new Thread(() -> {
			try {
				System.out.println("Thread " + Thread.currentThread().getId() + " is going to sleep for 1000ms");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("exception while sleeping");
			}
		});
		thread.start();
		Thread.sleep(100);
		System.out.println("Created and started thread " + thread.getId() + ". State is " + thread.getState());
	}

}
