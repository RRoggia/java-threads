package com.rroggia.threads.guardedblocks;

public class GuardedBlock implements Runnable {

	private int counter = 0;
	private MainThread mt = null;
	public static boolean joy;

	public GuardedBlock() {
		GuardedBlock.joy = false;
	}

	public GuardedBlock(MainThread mt) {
		this();

		this.mt = mt;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter++;
		}
		joy = true;
		System.out.println("Finish joy processing");

		if (mt != null) {
			System.out.println("Notifiying joy");
			mt.notifyJoy();
		}
	}

}
