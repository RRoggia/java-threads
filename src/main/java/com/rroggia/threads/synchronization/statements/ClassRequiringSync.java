package com.rroggia.threads.synchronization.statements;

import java.util.ArrayList;
import java.util.List;

public class ClassRequiringSync {

	private String lastName;
	private int nameCount;
	private List<String> nameList = new ArrayList<>();

	public void addName(String name) {
		synchronized (this) {
			lastName = name;
			nameCount++;
		}
		nameList.add(name);
	}

	public List<String> getNameList() {
		return nameList;
	}

}
