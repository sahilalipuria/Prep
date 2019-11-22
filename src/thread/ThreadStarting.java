package thread;

public class ThreadStarting extends Thread{
	
	public void run() {
		
		for(int i=0;i<10;i++) {
			
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadStarting thread1 = new ThreadStarting();
		thread1.start();
		
		ThreadStarting thread2 = new ThreadStarting();
		thread2.start();
	}

}
