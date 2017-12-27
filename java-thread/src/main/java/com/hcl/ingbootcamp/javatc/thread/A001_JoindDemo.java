package com.hcl.ingbootcamp.javatc.thread;

public class A001_JoindDemo {

	public static void main(String... args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("Hello I am from " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "thread1");
		t1.start();
		t1.join();
		System.out.println("Hello , I am from " + Thread.currentThread().getName());

	}

}
