/**
 * 
 */
package thread;

import java.util.Scanner;

/**
 * @author salipuri
 *
 */

public class ThreadWaitNotify {

	/**
	 * @param args
	 */
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread running.......");
			wait();
			System.out.println("Resumed......");
		}
		
	}

	public void consume() throws InterruptedException{
		Thread.sleep(2000);
		
		Scanner sc = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Waiting for return key.....");
			sc.nextLine();
			System.out.println("Return key pressed.....");
			notify();
			Thread.sleep(5000);
		}
	}
	
	public static void main(String[] args) {
		
		ThreadWaitNotify processor = new ThreadWaitNotify();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
