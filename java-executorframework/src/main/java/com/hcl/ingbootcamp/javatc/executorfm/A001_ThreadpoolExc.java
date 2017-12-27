package com.hcl.ingbootcamp.javatc.executorfm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class A001_ThreadpoolExc {

	public static void main(String... args) {

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(() -> System.out.println("hell from " + Thread.currentThread().getName()));
		executorService.shutdown();

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		scheduledExecutorService.schedule(
				() -> System.out.println("task 1 hello from " + Thread.currentThread().getName()), 5, TimeUnit.SECONDS);

		scheduledExecutorService.scheduleAtFixedRate(
				() -> System.out.println("periodic task hello form " + Thread.currentThread().getName()), 2, 1,
				TimeUnit.SECONDS);

	}

}
