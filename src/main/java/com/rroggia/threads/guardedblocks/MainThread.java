package com.rroggia.threads.guardedblocks;

public class MainThread {

	public static void main(String[] args) {
		MainThread mt = new MainThread();

		new Thread(new GuardedBlock()).start();
		mt.doSomething();

		new Thread(new GuardedBlock(mt)).start();
		mt.doSomethingWithWait();
	}

	public void doSomething() {
		while (!GuardedBlock.joy) {
			System.out.println("waiting");
		}
		System.out.println("Joy has been achieved");
	}

	public synchronized void doSomethingWithWait() {
		while (!GuardedBlock.joy) {
			System.out.println("waiting 2");
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		System.out.println("Joy has been achieved 2");
	}

	public synchronized void notifyJoy() {
		notifyAll();
	}
}
