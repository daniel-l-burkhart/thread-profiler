/**
 * 
 */
package controller;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import model.MedianFinder;
import model.PrimeFactor;
import model.SimpleAddition;

/**
 * The application class that shows all of the threads.
 * 
 * @author danielburkhart
 * @version 1.0
 */
public class Application {

	/**
	 * The main method
	 * 
	 * @param args
	 *            The args passed into the method
	 */
	public static void main(String[] args) {

		startThreads();
		System.err.close();
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();

		while (true) {

			printInitialHeader();

			for (long id : bean.getAllThreadIds()) {
				formatAndPrintOutThreadData(bean, id);
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static void startThreads() {
		(new Thread(new SimpleAddition())).start();
		(new Thread(new MedianFinder())).start();
		(new Thread(new PrimeFactor())).start();
	}

	private static void printInitialHeader() {
		System.out.println("--- Current Threads ---");
		System.out.printf("%5s | %10s| %15d| %15d| %5d| %10s", "No.", "Name", "CPU Time", "User Time", "User/CPU",
				"Thread State");
		System.out.println("\n------------------------");
	}

	private static void formatAndPrintOutThreadData(ThreadMXBean bean, long id) {

		ThreadInfo info = bean.getThreadInfo(id);

		long result = (long) bean.getThreadUserTime(id) / bean.getThreadCpuTime(id);

		System.out.println(String.format("%5s | %20s| %15d| %15d| %5d| %10s", info.getThreadId(), info.getThreadName(),
				bean.getThreadCpuTime(id), bean.getThreadUserTime(id), result, info.getThreadState()));

	}

}
