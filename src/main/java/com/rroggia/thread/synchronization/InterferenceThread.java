package com.rroggia.thread.synchronization;

public class InterferenceThread implements Runnable {

	private Counter counter;

	public InterferenceThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.increment();
	}

}
