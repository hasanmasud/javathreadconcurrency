package com.hcl.ingbootcamp.javatc.volatiles;

public class VolatileTest {

	private static volatile int myint = 0;

	private static final int RANGE = 5;

	public static void main(String[] args) {
		new ReadeThread().start();
		new UpdateThread().start();
	}

	static class ReadeThread extends Thread {
		@Override
		public void run() {
			int local_value = myint;
			while (local_value < RANGE) {
				if (local_value != myint) {
					local_value = myint;
					System.out.println("in ReadeThread : " + myint);
				}
			}
		}
	}

	static class UpdateThread extends Thread {
		@Override
		public void run() {
			int local_value = myint;
			while (myint < RANGE) {
				myint = ++local_value;
				System.out.println("in UpdateThread : " + myint);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}