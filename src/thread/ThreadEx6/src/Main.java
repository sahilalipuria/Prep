
class MyThread extends Thread {
	
	public void run() {
		
		for( ;; ) {
			
			if (interrupted()) {
				System.out.println("Thread is interrupted hence stopping..");
				break;
			}
			
			System.out.print("T");
		}
		
	}
	
}

public class Main {

	public static void main(String[] args) {

		MyThread thr = new MyThread();
		thr.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thr.interrupt();
	}

}
