/**
 * 
 */
package controller;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import model.MedianFinder;
import model.PrimeFactor;
import model.SimpleAddition;

/**
 * @author danielburkhart
 *
 */
public class Application {

	/**
	 * 
	 */
	public Application() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		(new Thread(new SimpleAddition())).start();
		(new Thread(new MedianFinder())).start();
		(new Thread(new PrimeFactor())).start();

		
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		
		while(true){
			System.out.println("---");
			for(long id: bean.getAllThreadIds()){
				System.out.println(id);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		/*
	
		*/

	}

}
