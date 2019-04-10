package com.rroggia.thread.exercise.two;

public class ConcurrentHelloWorld extends HelloWorld implements Runnable {

	@Override
	public void run() {
		hello();
	}

}
