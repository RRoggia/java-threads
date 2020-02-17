package com.rroggia.threads.synchronization.statements;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		ClassRequiringSync crs = new ClassRequiringSync();
		for (int i = 0; i < 10; i++) {
			new Thread(new SynchronizedStatement(crs)).start();
		}

		Thread.sleep(1000);

		System.out.println(crs.getNameList());

		MsLunch msLunch = new MsLunch();
		for (int i = 0; i < 10; i++) {
			new Thread(new SyncStatementDifferentLocks(msLunch)).start();
		}
	}
}
