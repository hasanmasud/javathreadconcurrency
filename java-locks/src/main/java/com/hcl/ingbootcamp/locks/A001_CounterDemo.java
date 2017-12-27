package com.hcl.ingbootcamp.locks;

public class A001_CounterDemo {

	private static A001_Counter c = new A001_Counter();

	public static void main(String... args) {
		startNewThread("thread-1");
		startNewThread("thread-2");
		startNewThread("thread-3");
	}

	private static void startNewThread(String name) {
		new Thread(() -> {
			while (true) {
				c.increasePrintCount();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, name).start();
	}

}
