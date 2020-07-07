
class MyThread extends Thread {
	
	public void run() {
		// DO THAT TASK HERE.
		for(int i=0; i <= 1000; i++) {
			System.out.print("T");
		}
	}
	
}

class MyTask implements Runnable {

	@Override
	public void run() {
		// DO THAT TASK HERE.
		for(int i=0; i <= 1000; i++) {
			System.out.print("-");
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		MyThread thr = new MyThread();
		thr.start();
		
		MyTask task = new MyTask();
		Thread thr2 = new Thread(task);
		thr2.start();
		
		for(int i=0; i <= 1000; i++) {
			System.out.print("M");
		}
		
	}

}
