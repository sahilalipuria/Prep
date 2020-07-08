/**
 * 
 */
package thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * @author salipuri
 *
 */


public class LowLevelSyncronization {

	/**
	 * @param args
	 */
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException{
		
		int value=0;
		while(true) {
			synchronized (lock) {
				while(list.size()==LIMIT)
					lock.wait();
				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException{
		
		Random random = new Random();
		while(true) {
			synchronized (lock) {
				while(list.size()==0)
					lock.wait();
				System.out.print("List size: "+list.size());
				int value = list.remove(0);
				System.out.println("; Value is :"+value);
			}
			Thread.sleep(random.nextInt(1000));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowLevelSyncronization processor = new LowLevelSyncronization();
		
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

		System.out.println("Finished....");
		
	}

}
