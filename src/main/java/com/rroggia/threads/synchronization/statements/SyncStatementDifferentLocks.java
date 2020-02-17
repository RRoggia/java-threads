package com.rroggia.threads.synchronization.statements;

public class SyncStatementDifferentLocks implements Runnable {

	private MsLunch msLunch;

	public SyncStatementDifferentLocks(MsLunch msLunch) {
		this.msLunch = msLunch;
	}

	@Override
	public void run() {
		msLunch.inc1();
		msLunch.inc2();
	}

}
