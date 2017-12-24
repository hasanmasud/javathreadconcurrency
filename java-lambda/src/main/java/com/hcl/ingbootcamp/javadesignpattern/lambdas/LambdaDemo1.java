package com.hcl.ingbootcamp.javadesignpattern.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo1 {

	private static List<String> cities = Arrays.asList("Kolkata", "Delhi", "Mumbai", "Chennai");

	public static void main(String... args) {
		System.out.println(cities.stream().map(String::toUpperCase).collect(Collectors.joining(",")));
	}

}
