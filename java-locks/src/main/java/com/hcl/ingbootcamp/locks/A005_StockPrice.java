package com.hcl.ingbootcamp.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A005_StockPrice {

	private double price;

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();

	public A005_StockPrice(double initPrice) {
		this.price = initPrice;
	}

	public void getStockPrice() {
		try {
			this.readLock.lock();
			this.price++;
			System.out.printf(" %s : %f \n ", Thread.currentThread().getName(), this.price);
		} finally {
			this.readLock.unlock();
		}
	}

	public void updatePrice() {
		try {
			this.writeLock.lock();
			System.out.println(Thread.currentThread().getName() + " has aquired the lock , updating the stock price");
			this.price = doSomeCalculation(price);
		} finally {
			this.writeLock.unlock();
		}
	}

	private double doSomeCalculation(double price) {
		price = price + 5;
		return price;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
