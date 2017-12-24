package com.hcl.ingbootcamp.javadesignpattern.lambdas;

public class LambdaDemo3 {

	public static void main(String... args) {

		new Thread(() -> System.out.println("Hello from lambda Thread " + Thread.currentThread().getName()), "thread-1")
				.start();
		new Thread(() -> System.out.println("Hello from lambda Thread " + Thread.currentThread().getName()), "thread-2")
				.start();
		new Thread(() -> System.out.println("Hello from lambda Thread " + Thread.currentThread().getName()), "thread-3")
				.start();
		new Thread(() -> System.out.println("Hello from lambda Thread " + Thread.currentThread().getName()), "thread-4")
				.start();
		new Thread(() -> System.out.println("Hello from lambda Thread " + Thread.currentThread().getName()), "thread-5")
				.start();
	}

	// private static void innerClassImpl() {
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// System.out.println("Hello from Thread " + Thread.currentThread().getName());
	// }
	// }, "thread-1").start();
	//
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// System.out.println("Hello from Thread " + Thread.currentThread().getName());
	// }
	// }, "thread-2").start();
	//
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// System.out.println("Hello from Thread " + Thread.currentThread().getName());
	// }
	// }, "thread-2").start();
	// }

}
