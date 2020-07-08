package thread;

import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running = true;	//Volatile prevents threads caching variables when they are not changed
	
	public void run() {
		
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		this.running = false;
	}
}

public class BasicThreadSynchronization {

	public static void main(String[] args) {
		
		Processor proc1 = new Processor();
		proc1.start();

		System.out.println("Press return to stop....");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		proc1.shutdown();
	}

}
