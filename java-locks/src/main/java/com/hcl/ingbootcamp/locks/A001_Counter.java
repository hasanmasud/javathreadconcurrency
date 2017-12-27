package com.hcl.ingbootcamp.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A001_Counter {

	private Lock lock = new ReentrantLock();
	private int counter = 0;

	public void increasePrintCount() {
		try {
			this.lock.lock();
			this.counter++;
			System.out.println(Thread.currentThread().getName() + " : " + this.counter);
		} finally {
			this.lock.unlock();
		}
	}

}
