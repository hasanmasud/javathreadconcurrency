package com.hcl.ingbootcamp.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A002_Counter {

	private Lock lock = new ReentrantLock();

	private int counter;

	public void increaseAndPrint() {
		try {
			boolean gotLock = this.lock.tryLock();
			if (gotLock) {
				this.counter++;
				System.out.println(Thread.currentThread().getName() + " : " + this.counter);
			} else {
				System.out.println(Thread.currentThread().getName() + " got locked : " + gotLock);
			}
		} finally {
			this.lock.unlock();
		}
	}

}
