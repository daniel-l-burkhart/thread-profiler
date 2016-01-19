/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author danielburkhart
 *
 */
public class SimpleAddition implements Runnable {

	private Random randomizer;

	/**
	 * 
	 */
	public SimpleAddition() {
		this.randomizer = new Random();
	}

	@Override
	public void run() {
		
		Thread.currentThread().setName("Simple Addition");

		while (true) {

			int a = (int)(Math.random()*100000);
			int b = (int)(Math.random()*100000);
			
			System.err.println(a+b);
			

		}

	}

}
