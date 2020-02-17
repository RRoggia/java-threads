package com.rroggia.threads.join;

public class PlayerOne implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			return;
		}
		System.out.println("Jogada do player one");
	}

}
