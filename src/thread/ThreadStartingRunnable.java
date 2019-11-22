package thread;

public class ThreadStartingRunnable implements Runnable{

	public static void main(String[] args) {
		Thread thread1 = new Thread(new ThreadStartingRunnable());
		thread1.start();
		
		Thread thread2 = new Thread(new ThreadStartingRunnable());
		thread2.start();

	}

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch bloc k
				e.printStackTrace();
			}
		}
		
	}

}
