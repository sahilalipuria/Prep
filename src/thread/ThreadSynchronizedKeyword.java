package thread;

public class ThreadSynchronizedKeyword {
	
	private int count = 0;
	
	/*
	 * For a synchronized block, the lock is acquired on the object specified in the parentheses after the synchronized keyword. 
	 * For a synchronized static method, the lock is acquired on the . class object. 
	 * For a synchronized instance method, the lock is acquired on the current instance of that class i.e. this instance.
	 * 
	 * When a thread tries to enter the synchronized block or method, it has to acquire a lock on the object being synchronized. 
	 * One and only one thread can acquire that lock at a time and execute code in that block.

		If another thread tries to access a synchronized block before the current thread completes its execution of the block, it has to wait. 
		When the current thread exits the block, the lock is automatically released and any waiting thread can acquire that lock and enter the synchronized block:
	 */
	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadSynchronizedKeyword thread = new ThreadSynchronizedKeyword();
		thread.doWord();

	}

	private void doWord() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
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
		
		System.out.println("Count is:"+count);
		
	}
	
	

}
