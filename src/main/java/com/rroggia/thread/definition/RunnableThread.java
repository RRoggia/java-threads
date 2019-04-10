package com.rroggia.thread.definition;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Created runnable thread " + Thread.currentThread().getName());
	}

}
