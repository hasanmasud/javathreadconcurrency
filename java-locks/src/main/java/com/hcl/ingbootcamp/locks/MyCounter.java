package com.hcl.ingbootcamp.locks;

public class MyCounter {

	private MyLock myLock = new MyLock();

	private int counter;

	public int increaseCounter() throws InterruptedException {
		try {
			myLock.lock();
			counter++;
			return counter;
		} finally {
			myLock.unlock();
		}
	}

}
