class MyTask implements Runnable {
	
	@Override
	public void run() {
		for (;;) {
			System.out.print("T");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		
		Thread thr = new Thread(new MyTask());
		thr.setDaemon(true);
		thr.start();
		
		for (int i=1; i <= 200; i++) {
			System.out.print(" M ");
		}
	}
}

