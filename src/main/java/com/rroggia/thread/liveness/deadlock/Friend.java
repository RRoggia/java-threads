package com.rroggia.thread.liveness.deadlock;

public class Friend {

	private String name;

	public Friend(String name) {
		this.name = name;
	}

	public synchronized void bow(Friend bower) {
		System.out.format("%s: %s has bowed to me! %n", this.name, bower.getName());
		bower.bowBack(this);

	}

	private synchronized void bowBack(Friend bower) {
		System.out.format("%s: %s has bowed back to me! %n", this.name, bower.getName());
	}

	public String getName() {
		return name;
	}

}
