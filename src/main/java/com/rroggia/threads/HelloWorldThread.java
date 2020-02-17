package com.rroggia.threads;

public class HelloWorldThread implements Runnable {
	private static int COUNT = 0;
	private int count;

	public HelloWorldThread() {
		this.count = COUNT++;
		System.out.println("Creating thread no:" + this.count);
		System.out.println("Creating thread no:" + this.count + " thread id :" + Thread.currentThread().getId());
	}

	@Override
	public void run() {
		System.out.println("Hello world, thread no: " + this.count);
		System.out.println("Hello world, thread no: " + this.count + "thread id :" + Thread.currentThread().getId());
	}

}
