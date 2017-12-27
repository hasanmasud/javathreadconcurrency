package com.hcl.ingbootcamp.locks;

public class A000_ThreadUnsafeCounterDemo {

	private static A000_ThreadUnsafeCounter tuc = new A000_ThreadUnsafeCounter();

	public static void main(String... args) {
		startNewThread("thread-1");
		startNewThread("thread-2");
		startNewThread("thread-3");
	}

	private static void startNewThread(String name) {
		new Thread(() -> {
			while (true) {
				tuc.increasePrintCount();
			}
		}, name).start();
	}

}
