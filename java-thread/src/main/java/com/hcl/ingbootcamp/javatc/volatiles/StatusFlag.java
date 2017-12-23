package com.hcl.ingbootcamp.javatc.volatiles;

public class StatusFlag {

	private static volatile boolean shutdownRequested;

	static class DoSomething extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("I am doing some work");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (shutdownRequested) {
					System.out.println("Received shutdown request. I am shutting down");
					return;
				}
			}

		}
	}

	public static void main(String... args) throws InterruptedException {
		new DoSomething().start();
		Thread.sleep(5000);
		shutdownRequested = true;
	}

}
