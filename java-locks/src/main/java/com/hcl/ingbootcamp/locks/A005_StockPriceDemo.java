package com.hcl.ingbootcamp.locks;

public class A005_StockPriceDemo {

	public static void main(String... args) {

		A005_StockPrice stockPrice = new A005_StockPrice(1.0d);

		new Thread(() -> {
			while (true) {
				stockPrice.getStockPrice();
			}
		}, "t-readstock1").start();

		// new Thread(() -> {
		// while (true) {
		// stockPrice.getStockPrice();
		// }
		// }, "t-readstock2").start();

		// new Thread(() -> {
		// while (true) {
		// stockPrice.updatePrice();
		// }
		// }, "t-updatestock1").start();

	}

}
