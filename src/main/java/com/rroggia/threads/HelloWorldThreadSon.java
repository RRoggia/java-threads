package com.rroggia.threads;

public class HelloWorldThreadSon extends Thread {

	public HelloWorldThreadSon() {
		super();
		System.out.println("Creating thread with id " + getId());
	}

	public void run() {
		System.out.println("Hello World, executing thread no :" + getId());
	}

}
