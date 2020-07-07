
class Task {
	public void doTask() {
		for(int i=1; i <= 1500; i++) {
			System.out.print("T");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		
		for(int i=1; i <= 1500; i++) {
			System.out.print("M");
		}
		
		Task t1 = new Task();
		t1.doTask();
	}

}
