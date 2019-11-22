package thread;

public class ThreadStartingRunnable2{

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			
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
		});
		thread1.start();

	}

}
