/**
 * 
 */
package thread;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author salipuri
 *
 */

class Account{
	
	private int balance = 1000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account acc1,Account acc2,int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}

public class ThreadDeadlock {

	/**
	 * @param args
	 */
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public void acquireLocks(Lock firstLock,Lock secondLock) {	//To avoid deadlocks
		
		while(true) {
			//Acquire locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			}
			finally {
				if(gotFirstLock && gotSecondLock)
					return;
				
				if(gotFirstLock)
					firstLock.unlock();
				
				if(gotSecondLock)
					secondLock.unlock();
			}
			
			//Locks not acquired
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void firstThread() throws InterruptedException{
		
		Random random = new Random();
		for(int i=0;i<10000;i++) {
			
			acquireLocks(lock1,lock2);
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Random random = new Random();
		for(int i=0;i<10000;i++) {
			acquireLocks(lock1,lock2);
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished() {
		System.out.println("Account 1 balance is: "+acc1.getBalance());
		System.out.println("Account 2 balance is: "+acc2.getBalance());
		System.out.println("Total balance: "+(acc1.getBalance()+acc2.getBalance()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadDeadlock processor = new ThreadDeadlock();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.firstThread();
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
					processor.secondThread();
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

		processor.finished();

	}

}
