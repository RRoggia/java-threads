package com.rroggia.threads.synchronization.methods;

public class ThreadMain {

	private static class ConcurrentIncrementCounter implements Runnable {

		private SynchronizedCounter counter;

		public ConcurrentIncrementCounter(SynchronizedCounter counter) {
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

		private SynchronizedCounter counter;

		public ConcurrentDecrementCounter(SynchronizedCounter counter) {
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
		SynchronizedCounter counter = new SynchronizedCounter();

		System.out.println("Create Decrement");
		Thread t1 = new Thread(new ConcurrentDecrementCounter(counter));
		System.out.println("Create Increment");
		Thread t2 = new Thread(new ConcurrentIncrementCounter(counter));

		System.out.println("Start threads");
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Counter is :" + counter.value());

	}

}
