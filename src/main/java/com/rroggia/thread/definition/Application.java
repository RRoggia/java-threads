package com.rroggia.thread.definition;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Current thread is: " + Thread.currentThread().getName());

		System.out.println("Create start RunnableThread: ");
		for (int i = 0; i < 10; i++) {
			new Thread(new RunnableThread()).start();
		}

		Thread.sleep(100);

		System.out.println("Start ExtendsThread");
		for (int i = 0; i < 10; i++) {
			new ExtendsThread().start();
		}
	}

}
