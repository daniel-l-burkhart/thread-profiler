package model;

import java.util.Random;

/**
 * The prime factor class
 * @author danielburkhart
 * @version 1.0
 */
public class PrimeFactor implements Runnable {

	@Override
	public void run() {

		Random randomizer = new Random();
		Thread.currentThread().setName("Prime Factor");

		while (true) {

			int value = randomizer.nextInt(200000 - 100000) + 100000;

			if (this.findPrime(value)) {
				System.err.println(value + " is prime.");
			} else {
				System.err.println(value + " is not prime.");
			}

		}

	}

	/**
	 * Private helper method to find if a number is prime or not
	 * 
	 * @param value
	 *            The value passed in
	 * @return True if prime, false otherwise.
	 */
	private boolean findPrime(int value) {
		boolean prime;
		prime = true;
		for (int i = 2; i < value - 1; i++) {
			if (value % i == 0) {
				prime = false;
			}
		}
		return prime;

	}

}
