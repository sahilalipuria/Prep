/**
 * 
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author salipuri
 *
 */

class Connection{
	
	private static Connection instance = new Connection();
	private int connections=0;
	
	private Semaphore sem = new Semaphore(10,true);
	
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			doConnect();
		}finally {
			sem.release();
		}
	}
	
	public void doConnect() {
		
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: "+connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
		}
	}
}

public class Semaphores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Semaphore sem = new Semaphore(1);
		
		//sem.release();
		try {
			sem.acquire();
			sem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Available permits: "+sem.availablePermits());*/
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++) {
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
					
				}
			});
		}

		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
