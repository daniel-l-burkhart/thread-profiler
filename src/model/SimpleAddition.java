/**
 * 
 */
package model;

/**
 * Simple Addition class
 * 
 * @author danielburkhart
 * @version 1.0
 */
public class SimpleAddition implements Runnable {

	@Override
	public void run() {

		Thread.currentThread().setName("Simple Addition");

		while (true) {

			int a = (int) (Math.random() * 100000);
			int b = (int) (Math.random() * 100000);

			System.err.println(a + b);

		}

	}

}
