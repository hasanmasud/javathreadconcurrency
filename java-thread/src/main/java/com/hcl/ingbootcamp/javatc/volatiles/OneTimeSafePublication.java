package com.hcl.ingbootcamp.javatc.volatiles;

public class OneTimeSafePublication {

	static class BackgroundFloobleLoader {
		public volatile SomeData someData;

		public void initInBackground() {
			someData = new SomeData(); // this is the only write to theFlooble
			someData.setName("Sachin Tendulkar");
		}
	}

	static class SomeOtherClass {

		private BackgroundFloobleLoader backgroundFloobleLoader;

		SomeOtherClass(BackgroundFloobleLoader backgroundFloobleLoader) {
			this.backgroundFloobleLoader = backgroundFloobleLoader;
		}

		public void doWork() {
			while (true) {
				// do some stuff...
				// use the Flooble, but only if it is ready
				if (this.backgroundFloobleLoader.someData != null) {
					System.out.println(this.backgroundFloobleLoader.someData.getName());
					break;
				}
			}
		}
	}

	static class SomeData {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String... args) throws InterruptedException {
		final BackgroundFloobleLoader backgroundFloobleLoader = new BackgroundFloobleLoader();

		new Thread(new Runnable() {
			public void run() {
				backgroundFloobleLoader.initInBackground();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				new SomeOtherClass(backgroundFloobleLoader).doWork();
			}
		}).start();

	}

}
