package com.hcl.ingbootcamp.locks;

public class A004_MyBlockingQueueDemo {

	private static A004_MyBlockingQueue myBlockingQueue = new A004_MyBlockingQueue(1);

	public static void main(String... args) {
		createProducer("pthread-1");
		// createProducer("pthread-2");
		createConsumer("cthread-1");
	}

	public static void createProducer(String name) {
		new Thread(() -> {
			try {
				while (true) {
					Number number = Math.random();
					myBlockingQueue.put(number);
					System.out.println(Thread.currentThread().getName() + " produced : " + number);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, name).start();
	}

	public static void createConsumer(String name) {
		new Thread(() -> {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " consumed : " + myBlockingQueue.get());
					Thread.sleep(1000);
				}
			} catch (InterruptedException interruptedException) {
			}

		}, name).start();
	}

}
