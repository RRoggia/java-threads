package com.rroggia.thread.synchronization;

import com.rroggia.thread.synchronization.method.CounterMethodSynchronized;
import com.rroggia.thread.synchronization.statement.CounterStatementSynchronized;

public class InterferenceExample {

	public static void main(String[] args) throws InterruptedException {
		Counter counterInterference = new Counter(); // implementation interleaves
		CounterStatementSynchronized counterStatement = new CounterStatementSynchronized(); // implementation doesn't interleave
		CounterMethodSynchronized counterMethod = new CounterMethodSynchronized(); // implementation doesn't interleave
		
		// replace with one of the implementation from above
		Counter counter = counterMethod;

		Thread t1 = null;
		for (int i = 0; i < 100; i++) {
			t1 = new Thread(new InterferenceThread(counter));
			t1.start();
		}

		t1.join();

		for (Long threadId : Counter.start.keySet()) {
			System.out.printf("Thread %d started with %d \n", threadId, Counter.start.get(threadId));
			System.out.printf("Thread %d finished with %d \n", threadId, Counter.finish.get(threadId));
		}

	}

}
