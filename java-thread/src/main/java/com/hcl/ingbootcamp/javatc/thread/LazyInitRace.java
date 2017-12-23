package com.hcl.ingbootcamp.javatc.thread;

import net.jcip.annotations.NotThreadSafe;

/**
 * 
 * @author masud
 *
 *         Race Cpmdition - > may end yp creating multiple objects , where only
 *         one instance is desirable
 */
@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;

	public ExpensiveObject getInstance() {
		if (instance == null)
			instance = new ExpensiveObject();
		return instance;
	}
}