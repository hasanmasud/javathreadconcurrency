package com.hcl.ingbootcamp.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A003_Counter {

	private Lock lock = new ReentrantLock();
	private int count;

	public void increaseAndPrint() {
		try {
			this.lock.lockInterruptibly();
			this.count++;
			System.out.println(Thread.currentThread().getName() + " : " + this.count);
		} catch (InterruptedException interruptedException) {
			System.out.println(Thread.currentThread().getName() + " is interuppted, can't obtain lock");
		} finally {
			this.lock.unlock();
		}
	}

}
