package com.hcl.ingbootcamp.javatc.thread;

import net.jcip.annotations.NotThreadSafe;

/**
 * @author masud
 *
 *
 *
 * This is not thread safe
 */
@NotThreadSafe
public class UnsafeSequence {

	private int value;

	/** Returns a unique value. */
	public int getNext() {
		return value++;
	}
}