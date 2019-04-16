package com.rroggia.thread.synchronization.method;

import com.rroggia.thread.synchronization.Counter;

public class CounterMethodSynchronized extends Counter {
	@Override
	public synchronized void increment() {
		super.increment();
	}
}
