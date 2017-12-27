package com.hcl.ingbootcamp.javatc.executorfm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class A002_InvokeAll {

	public static void main(String... args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Set<Callable<String>> setOfCallable = new HashSet<>();
		// List<Callable<String>> setOfCallable = new ArrayList<>();
		setOfCallable.add(() -> {
			Thread.sleep(5000);
			return "this is task 1";
		});
		setOfCallable.add(() -> "this is task 2");
		setOfCallable.add(() -> "this is task 3");
		setOfCallable.add(() -> "this is task 4");
		List<Future<String>> listFuture = executorService.invokeAll(setOfCallable);

		executorService.shutdown();

		listFuture.forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
