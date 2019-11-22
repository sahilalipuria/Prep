/**
 * 
 */
package sorting;

/**
 * @author salipuri
 *
 */
public class BogoSort {

	/**
	 * @param args
	 */
	
	//Fisher Yates algo
	public static void shuffle(int[] nums) {
		for(int i=nums.length-1;i>=0;i--) {
			int j = (int)(Math.random()*i);
			swap(nums,i,j);
		}
	}
	
	public static void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static boolean isSorted(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void showArray(int[] nums) {
		
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {12,-4,56,0,3,8,2,1};
		int loopCounter = 0;
		
		while(!isSorted(nums)) {
			++loopCounter;
			shuffle(nums);
		}
		
		System.out.println("Steps required to sort: "+loopCounter);
		showArray(nums);
	}

}
