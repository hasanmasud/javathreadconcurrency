package com.hcl.ingbootcamp.locks;

public class A000_ThreadUnsafeCounter {

	private int counter;

	public void increasePrintCount() {
		this.counter++;
		System.out.println(Thread.currentThread().getName() + " : " + this.counter);
	}

}
