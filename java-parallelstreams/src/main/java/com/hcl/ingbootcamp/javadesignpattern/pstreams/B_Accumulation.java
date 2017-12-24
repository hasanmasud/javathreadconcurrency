package com.hcl.ingbootcamp.javadesignpattern.pstreams;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class B_Accumulation {

	private static final long LIMIT = 1_000_000L;

	public static void main(String... args) {
		sum();
		sumAccu();
		sumByReduction();
	}

	public static void sum() {
		long sum = 0L;
		for (long i = 0; i <= LIMIT; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	public static void sumAccu() {
		// long sum = 0L;
		// LongStream.rangeClosed(1, LIMIT).forEach(i -> sum += i);

		long suma[] = { 0L };
		LongStream.rangeClosed(1, LIMIT).forEach(i -> suma[0] += i);
		System.out.println(suma[0]);

		long sump[] = { 0L };
		LongStream.rangeClosed(1, LIMIT).parallel().forEach(i -> sump[0] += i);
		System.out.println(sump[0]);

		// this is very slow : be careful
		AtomicLong atSum = new AtomicLong();
		LongStream.rangeClosed(1, LIMIT).parallel().forEach(atSum::addAndGet);
		System.out.println(atSum.get());
	}

	public static void sumByReduction() {
		long sum = LongStream.rangeClosed(1, LIMIT).parallel().reduce(0L, (x, y) -> x + y);
		System.out.println(sum);
	}

}
