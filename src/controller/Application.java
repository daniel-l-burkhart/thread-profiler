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
		System.out.println("---");
		System.out.println("--- Current Threads ---");
		System.out.println("No. / Name/ CPU Time / User Time/ User/CPU // Thread State");
	}

	private static void formatAndPrintOutThreadData(ThreadMXBean bean, long id) {
		ThreadInfo info = bean.getThreadInfo(id);

		System.out.printf("%d| %s| %d| %d| %d %s", info.getThreadId(), info.getThreadName(), bean.getThreadCpuTime(id),
				bean.getThreadUserTime(id), bean.getThreadCpuTime(id) / bean.getThreadUserTime(id),
				info.getThreadState());
		System.out.println("");
	}

}
