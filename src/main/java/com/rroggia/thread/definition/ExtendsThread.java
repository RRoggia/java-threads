package com.rroggia.thread.definition;

public class ExtendsThread extends Thread {

	@Override
	public void run() {
		System.out.println("Created extend thread " + this.getName());
	}

}
