package com.hcl.ingbootcamp.javatc.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {

	@GuardedBy("this")
	private int nextValue;

	public synchronized int getNext() {
		return nextValue++;
	}
}