package com.rroggia.thread.synchronization;

import java.util.HashMap;

public class Counter {

	public static HashMap<Long, Integer> start = new HashMap<>();
	public static HashMap<Long, Integer> finish = new HashMap<>();

	private Integer c = 0;

	public void increment() {
		start.put(Thread.currentThread().getId(), c);
		c = c + 1;
		finish.put(Thread.currentThread().getId(), c);
	}

	public void decrement() {
		start.put(Thread.currentThread().getId(), c);
		c = c - 1;
		finish.put(Thread.currentThread().getId(), c);
	}

	public int value() {
		return c;
	}

}
