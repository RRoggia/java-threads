package com.rroggia.thread.synchronization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Counter {

	public static Map<Long, Integer> start = new ConcurrentHashMap<>();
	public static Map<Long, Integer> finish = new ConcurrentHashMap<>();

	protected Integer c = 0;

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
