package com.hcl.ingbootcamp.pstreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A_Ordering {

	public static void main(String... args) {
		// oredering();
		// paralleloredering();
		parallelorederingShow();
	}

	public static void oredering() {
		List<String> strList = IntStream.range(0, 20).filter(i -> i % 2 == 0).mapToObj(String::valueOf)
				.collect(Collectors.toList());
		System.out.println(strList);
	}

	public static void paralleloredering() {
		List<String> strList = IntStream.range(0, 20).parallel().filter(i -> i % 2 == 0).mapToObj(String::valueOf)
				.collect(Collectors.toList());
		System.out.println(strList);
	}

	public static void parallelorederingShow() {
		// List<String> peekon = new ArrayList<>();
		List<String> peekon = Collections.synchronizedList(new ArrayList<>());

		List<String> strList = IntStream.range(0, 20).parallel().filter(i -> i % 2 == 0).mapToObj(String::valueOf)
				.peek(peekon::add).collect(Collectors.toList());

		System.out.println(peekon);
		System.out.println(strList);
	}

}
