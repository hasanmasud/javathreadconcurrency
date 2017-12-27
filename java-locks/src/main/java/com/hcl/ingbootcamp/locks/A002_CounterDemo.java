package com.hcl.ingbootcamp.locks;

public class A002_CounterDemo {

	private static A002_Counter c = new A002_Counter();

	public static void main(String... args) {
		startNewThread("thread-1");
		startNewThread("thread-2");
		startNewThread("thread-3");
	}

	private static void startNewThread(String name) {
		new Thread(() -> {
			int range = 0;
			try {
				while (range < 5) {
					c.increaseAndPrint();
					range++;
					// Thread.sleep(1000);
				}
			} catch (Exception interruptedException) {
			}
		}, name).start();
	}

}
