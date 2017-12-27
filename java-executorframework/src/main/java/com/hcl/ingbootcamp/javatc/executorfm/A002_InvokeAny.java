package com.hcl.ingbootcamp.javatc.executorfm;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A002_InvokeAny {

	public static void main(String... args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> setOfCallable = new HashSet<>();
		setOfCallable.add(() -> "this is task 1");
		setOfCallable.add(() -> "this is task 2");
		setOfCallable.add(() -> "this is task 3");
		setOfCallable.add(() -> "this is task 4");
		setOfCallable.add(() -> "this is task 5");

		String result = executorService.invokeAny(setOfCallable);
		executorService.shutdown();
		System.out.println(result);
	}

}
