package com.rroggia.thread.exercise.two;

public class MainClass {

	public static void main(String[] args) {
		new Thread(new ConcurrentHelloWorld()).start();
		new Thread(new ConcurrentHelloThread()).start();
	}

}
