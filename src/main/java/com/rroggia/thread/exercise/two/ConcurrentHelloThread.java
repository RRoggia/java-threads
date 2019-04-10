package com.rroggia.thread.exercise.two;

public class ConcurrentHelloThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hello thread with id " + this.getId() + " and name " + this.getName());
	}

}
