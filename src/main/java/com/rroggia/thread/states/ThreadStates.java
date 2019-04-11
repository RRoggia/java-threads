package com.rroggia.thread.states;

public class ThreadStates {

	private static Object object = new Object();

	public static void main(String[] args) throws InterruptedException {

		demonstrateNewRunnableAndTerminatedStates();

		System.out.println();

		demonstrateTimedWaitingState();

		System.out.println();

		demonstrateBlockedState();

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

	private static void demonstrateTimedWaitingState() throws InterruptedException {
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

	private static void demonstrateBlockedState() throws InterruptedException {
		Runnable blocker = () -> {
			Thread currentThread = Thread.currentThread();
			synchronized (object) {
				System.out.println("Thread " + currentThread.getId() + " is locking object");
				for (int i = 0; i < Integer.MAX_VALUE; i--)
					if ((i * 3.5 / 8) == 0)
						;
			}
			System.out.println("Thread " + currentThread.getId() + " unlocked object");
		};

		Thread threadA = new Thread(blocker);
		Thread threadB = new Thread(blocker);
		threadA.start();
		threadB.start();
		Thread.sleep(100);
		System.out.println("Thread " + threadA.getId() + " created and started. State is " + threadA.getState());
		System.out.println("Thread " + threadB.getId() + " created and started. State is " + threadB.getState());
	}

}
