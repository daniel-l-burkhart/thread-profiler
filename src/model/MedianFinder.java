/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The median finder class.
 * 
 * @author danielburkhart
 * @version 1.0
 */
public class MedianFinder implements Runnable {

	private Random randomizer;
	private ArrayList<Integer> medianValues;

	/**
	 * The constructor of the median finder class.
	 */
	public MedianFinder() {
		this.randomizer = new Random();
		this.medianValues = new ArrayList<Integer>();
	}

	@Override
	public void run() {

		Thread.currentThread().setName("Median Finder");

		while (true) {

			this.populateRandomArray();

			Collections.sort(this.medianValues);

			int middle = this.medianValues.size() / 2;

			if (this.medianValues.size() % 2 == 0) {

				System.err.println((this.medianValues.get(middle) + this.medianValues.get(middle + 1) / 2) + " is median.");
			} else {
				System.err.println(this.medianValues.get(middle) + " is median");
			}

		}
	}

	/**
	 * @param randomizer
	 * @param medianValues
	 */
	private void populateRandomArray() {
		int randomSize = this.randomizer.nextInt(200000 - 100000) + 100000;
		for (int i = 0; i < randomSize; i++) {
			this.medianValues.add(this.randomizer.nextInt());
		}
	}

}
