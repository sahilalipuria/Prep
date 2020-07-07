import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer and Consumer problem
//    producer --> messageQueue --> consumer.


class ProducerThread extends Thread {
	BlockingQueue<String> queue;
	
	public ProducerThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=1; i <= 10; i++) {
			String msg = "Hello-" + i;
			try {
				queue.put(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produced - " + msg);
		}
	}
}


class ConsumerThread extends Thread {
	BlockingQueue<String> queue;
	
	public ConsumerThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			String message;
			try {
				message = queue.take();
				System.out.println("Consumed - " + message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		new ProducerThread(queue).start();
		new ConsumerThread(queue).start();
	}

}
