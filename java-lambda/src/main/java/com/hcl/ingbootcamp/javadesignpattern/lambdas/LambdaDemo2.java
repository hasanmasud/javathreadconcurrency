package com.hcl.ingbootcamp.javadesignpattern.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo2 {

	private static List<Integer> lisInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	public static void main(String... args) {

		lisInt.forEach(x -> System.out.print(x));
		lisInt.forEach((x) -> System.out.print(x));
		lisInt.forEach((Integer x) -> System.out.print(x));

		lisInt.forEach(x -> {
			x += 2;
			System.out.print(x);
		});

		lisInt.forEach(x -> {
			int y = x * 2;
			System.out.print(y);
		});

		Consumer<Integer> consumer = x -> System.out.print(x);
		lisInt.forEach(consumer);

		lisInt.forEach(System.out::print);

	}

}
