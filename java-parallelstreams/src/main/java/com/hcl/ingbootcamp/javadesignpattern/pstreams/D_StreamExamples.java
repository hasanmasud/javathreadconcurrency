package com.hcl.ingbootcamp.javadesignpattern.pstreams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D_StreamExamples {

	public static void main(String... args) {

		// System.out.println(Runtime.getRuntime().availableProcessors());
		// System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
		// "2");

		displayCommonPool();
	}

	public static void displayCommonPool() {
		Map<String, List<Integer>> map = IntStream.range(0, 128).parallel().boxed()
				.collect(Collectors.groupingBy(i -> Thread.currentThread().getName()));
		map.forEach((k, v) -> System.out.println("key : " + k + " , size : {" + v.size() + "} , " + v));
	}

	public static void displayDoAlitteMore() {
		Map<String, List<Integer>> map = IntStream.range(0, 128).parallel().boxed().peek(e -> consumeCPU(e))
				.collect(Collectors.groupingBy(i -> Thread.currentThread().getName()));
		map.forEach((k, v) -> System.out.println("key : " + k + " , size : {" + v.size() + "} , " + v));
	}

	private static void consumeCPU(Integer e) {
		for (int i = 0; i < 1_000_000; i++) {
			Math.pow(e, 1_000_000);
		}
	}

}
