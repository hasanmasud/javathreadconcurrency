package com.hcl.ingbootcamp.javatc.executorfm;

import java.util.concurrent.Executor;

public class A001_ThreadPerTaskExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}

	public static void main(String... args) {
		A001_ThreadPerTaskExecutor taskExecutor = new A001_ThreadPerTaskExecutor();
		taskExecutor.execute(() -> System.out.println("this is my task"));
	}

}
