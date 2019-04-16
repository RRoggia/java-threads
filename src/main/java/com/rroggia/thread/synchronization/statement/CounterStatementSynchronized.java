package com.rroggia.thread.synchronization.statement;

import com.rroggia.thread.synchronization.Counter;

public class CounterStatementSynchronized extends Counter {

	@Override
	public void increment() {
		synchronized (c) {
			super.increment();
		}
	}
}
