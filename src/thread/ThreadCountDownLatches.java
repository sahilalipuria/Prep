package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OtherProcessor implements Runnable{
	
	private CountDownLatch latch;
	
	public OtherProcessor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}


public class ThreadCountDownLatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownLatch latch =  new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<5;i++) {
			executor.submit(new OtherProcessor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed");
	}

}
