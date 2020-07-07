
class Task extends Thread {
	
	public void run() {
		doTask();
	}
	
	public void doTask() {
		for(int i=1; i <= 1500; i++) {
			System.out.print("T");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		
		Task t1 = new Task();
		t1.start();
		
		for(int i=1; i <= 1500; i++) {
			System.out.print("M");
		}
		
	}

}
