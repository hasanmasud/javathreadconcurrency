package com.hcl.ingbootcamp.locks;

public class A003_CounterDemo {

	private static A003_Counter c = new A003_Counter();

	public static void main(String... args) {
		Thread t1 = createNewThread("thread-1");
		Thread t2 = createNewThread("thread-2");
		Thread t3 = createNewThread("thread-3");

		t1.start();
		t1.interrupt();
		t2.start();
		t3.start();

	}

	private static Thread createNewThread(String name) {
		return new Thread(() -> {
			for (int range = 0; range < 5; range++) {
				c.increaseAndPrint();
			}
		}, name);
	}

}
