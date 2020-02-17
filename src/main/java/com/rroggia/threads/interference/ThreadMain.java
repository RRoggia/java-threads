package com.rroggia.threads.interference;

public class ThreadMain {

	private static class ConcurrentIncrementCounter implements Runnable {

		private Counter counter;

		public ConcurrentIncrementCounter(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			System.out.println("Incrementor - Counter is " + this.counter.value());
			counter.increment();
			System.out.println("Incrementor - After increment counter is " + this.counter.value());
		}
	}

	private static class ConcurrentDecrementCounter implements Runnable {

		private Counter counter;

		public ConcurrentDecrementCounter(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			System.out.println("Decrementor - Counter is " + this.counter.value());
			counter.decrement();
			System.out.println("Decrementor - After decrement counter is " + this.counter.value());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		System.out.println("Create Increment");
		Thread t1 = new Thread(new ConcurrentIncrementCounter(counter));

		System.out.println("Create Decrement");
		Thread t2 = new Thread(new ConcurrentDecrementCounter(counter));

		System.out.println("Start threads");
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Counter is :" + counter.value());
	}

}
