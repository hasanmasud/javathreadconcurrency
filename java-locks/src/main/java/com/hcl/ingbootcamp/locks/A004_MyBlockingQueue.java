package com.hcl.ingbootcamp.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A004_MyBlockingQueue {

	private Queue<Number> queue = new LinkedList<>();
	private Lock lock = new ReentrantLock();
	private Condition putIsPossible = lock.newCondition();
	private Condition getIsPOssible = lock.newCondition();
	private int capacity;

	public A004_MyBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	public void put(Number number) throws InterruptedException {
		try {
			this.lock.lock();
			if (this.queue.size() == this.capacity) {
				System.out.println("queue is full , " + Thread.currentThread().getName() + " should wait");
				this.putIsPossible.await();
			}
			this.queue.add(number);
			this.getIsPOssible.signalAll();
		} finally {
			this.lock.unlock();
		}
	}

	public Number get() throws InterruptedException {
		Number number = null;
		try {
			this.lock.lock();
			if (this.queue.isEmpty()) {
				System.out.println("queue is empty , " + Thread.currentThread().getName() + " should wait");
				this.getIsPOssible.await();
			}
			number = this.queue.poll();
			this.putIsPossible.signalAll();
			return number;
		} finally {
			this.lock.unlock();
		}
	}

}
