package com.rroggia.thread.synchronization;

public class InterferenceExample {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter();

		Thread t1 = null;
		for (int i = 0; i < 100; i++) {
			t1 = new Thread(new InterferenceThread(counter));
			t1.start();
		}
		t1.join();

		for (Long key : Counter.start.keySet()) {
			System.out.printf("Thread %d started with %d\n", key, Counter.start.get(key));
			System.out.printf("Thread %d finished with %d\n", key, Counter.finish.get(key));
		}

	}

}
