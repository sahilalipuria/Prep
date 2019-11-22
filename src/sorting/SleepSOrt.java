/**
 * 
 */
package sorting;

import java.util.concurrent.CountDownLatch;

/**
 * @author salipuri
 *
 */
public class SleepSOrt {

	/**
	 * @param args
	 */
	
	public void sleepSortAndPrint(int[] nums) {
		
		CountDownLatch countLatch = new CountDownLatch(nums.length);
		
		for(Integer num: nums) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					countLatch.countDown();
					try {
						countLatch.await();
						Thread.sleep(num*1000);
						System.out.println(num+"  ");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			});.start();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,4,2,6,8,5,6,9};
		SleepSOrt sleepSOrt = new SleepSOrt();
		sleepSOrt.sleepSortAndPrint(nums);
	}

}
