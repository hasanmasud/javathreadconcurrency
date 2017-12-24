package com.hcl.ingbootcamp.javadesignpattern.pstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class C_Identity {

	private static final List<String> cities = Arrays.asList("mumbai", "bengaluru", "kolkata", "delhi");

	public static void main(String... args) {

		// System.out.println(IntStream.rangeClosed(1, 8).parallel().reduce(0, (x, y) ->
		// x + y));
		// System.out.println(IntStream.rangeClosed(1, 8).parallel().reduce(1, (x, y) ->
		// x + y));

		// identity();
		associativity();

	}

	public static void identity() {
		System.out.println(cities.stream().parallel().map(s -> "{" + s + "}").reduce("", (s1, s2) -> s1 + s2));
		System.out.println(cities.stream().map(s -> "{" + s + "}").reduce("XXX", (s1, s2) -> s1 + s2));
		System.out.println(cities.stream().parallel().map(s -> "{" + s + "}").reduce("XXX", (s1, s2) -> s1 + s2));

		System.out.println(cities.stream().map(s -> new StringBuilder().append("{").append(s).append("}"))
				.reduce(new StringBuilder(), (b1, b2) -> b1.append(b2)));

		System.out.println(cities.stream().parallel().map(s -> new StringBuilder().append("{").append(s).append("}"))
				.reduce(new StringBuilder(), (b1, b2) -> b1.append(b2)));
	}

	public static void associativity() {
		System.out.println(cities.stream().parallel().map(s -> "{" + s + "}").reduce("", (s1, s2) -> s1 + s2));
		System.out.println(cities.stream().parallel().map(s -> "{" + s + "}").reduce("", (s1, s2) -> s1 + s2 + s1));

	}

}
