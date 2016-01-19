package model;

import java.util.Random;

public class PrimeFactor implements Runnable {

	private Random randomizer;

	public PrimeFactor() {
		this.randomizer = new Random();
		//random.nextInt(max - min + 1) + min

	}

	@Override
	public void run() {

		/*
		 * Assume by default all numbers are prime 
		 * prime = true; 
		 * for(i=2;i<value-1; i++) 
		 * 	if(value %i == 0) 
		 * 		prime = false 
		 * return prime;
		 */

	}

}
