package com.rroggia.threads;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new HelloWorldThread()).start();
		}

		for (int i = 0; i < 10; i++) {
			new HelloWorldThreadSon().start();
		}
	}

}
