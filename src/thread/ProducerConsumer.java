package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producer();
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
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}
	
	private static void producer() throws InterruptedException {
		Random rand = new Random();
		while(true) {
			queue.put(rand.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		
		while(true) {
			Thread.sleep(100);
			if(random.nextInt(10)==0) {
				Integer value = queue.take();
				
				System.out.println("Taken value: "+value+"; Queue size: "+queue.size());
			}
		}
	}

}
