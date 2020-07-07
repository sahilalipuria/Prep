/*
 * Thread priorities range between 1 and 10.
 * MIN_PRIORITY - 1
 * NORM_PRIORITY - 5 (default)
 * MAX_PRIORITY - 10 
 */

class CopyTask implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.print("C");
		}
	}
}

class ProgressTask implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.print("-");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		CopyTask copyTask = new CopyTask();
		Thread copyThread = new Thread(copyTask);
		copyThread.setPriority(Thread.NORM_PRIORITY + 3);
		copyThread.start();
		
		ProgressTask progressTask = new ProgressTask();
		Thread progressThread = new Thread(progressTask);
		progressThread.start();
	}

}
