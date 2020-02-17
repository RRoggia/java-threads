package com.rroggia.thread.liveness.deadlock;

public class DeadLock {
	
	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		
		final Friend ghaston = new Friend("Ghaston");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				alphonse.bow(ghaston);
				
			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				ghaston.bow(alphonse);
				
			}
				
		}).start();
	}

}
