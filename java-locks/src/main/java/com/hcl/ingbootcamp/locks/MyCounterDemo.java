package com.hcl.ingbootcamp.locks;

public class MyCounterDemo {

	public static void main(String... agrs) {

		MyCounter myCounter = new MyCounter();

		new Thread(() -> {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " : " + myCounter.increaseCounter());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "thread-1").start();

		new Thread(() -> {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " : " + myCounter.increaseCounter());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "thread-2").start();

		new Thread(() -> {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " : " + myCounter.increaseCounter());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "thread-3").start();

	}

}
