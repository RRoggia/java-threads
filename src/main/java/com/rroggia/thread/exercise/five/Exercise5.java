package com.rroggia.thread.exercise.five;

public class Exercise5 {

	public static void main(String[] args) throws InterruptedException {

		Thread firstThread = new Thread(() -> {
			long threadId = Thread.currentThread().getId();
			System.out.printf("Thread %d is executing \n", threadId);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				System.out.printf("Thread %d was interrupted\n", threadId);
			}
			System.out.printf("thread %d finished its execution\n", threadId);

		});

		Thread secondThread = new Thread(() -> {
			long threadId = Thread.currentThread().getId();
			System.out.printf("Thread %d is executing \n", threadId);
			try {
				System.out.printf("Thread %d is waiting for thread %d\n", threadId, firstThread.getId());
				firstThread.join();
			} catch (InterruptedException e) {
				System.out.printf("Thread %d was interrupted\n", threadId);
			}

			System.out.printf("thread %d finished its execution\n", threadId);
		});

		System.out.printf("Created and started thread %d \n", firstThread.getId());
		System.out.printf("Created and started thread %d \n", secondThread.getId());

		firstThread.start();
		secondThread.start();
		
		Thread.sleep(100);
		System.out.printf("Thread %d has the state %s\n", firstThread.getId(), firstThread.getState());
		System.out.printf("Thread %d has the state %s\n", secondThread.getId(), secondThread.getState());

	}

}
