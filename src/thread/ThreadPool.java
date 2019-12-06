/**
 * 
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author salipuri
 *
 */

class NewProcessor implements Runnable{
	
	private int id;
	
	public NewProcessor(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting: "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed: "+id);
	}
}

public class ThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++) {
			executor.submit(new NewProcessor(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");

	}

}
