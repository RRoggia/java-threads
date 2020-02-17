package com.rroggia.threads.synchronization.statements;

public class SynchronizedStatement implements Runnable {

	private ClassRequiringSync classRequiringSync;

	public SynchronizedStatement(ClassRequiringSync classRequiringSync) {
		this.classRequiringSync = classRequiringSync;
	}

	@Override
	public void run() {
		classRequiringSync.addName("Thread " + Thread.currentThread().getId());

	}

}
