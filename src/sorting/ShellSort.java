/**
 * 
 */
package sorting;

/**
 * @author salipuri
 *
 */
public class ShellSort {

	/**
	 * @param args
	 */
	public static void showArray(int[] nums) {
		
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
	}
	
	public static void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void shellSort(int[] nums) {
		
		for(int gap=nums.length/2;gap>0;gap/=2) {
			for(int i=gap;i<nums.length;i++) {
				int j=i;										//Insertion sort logic. Advantage : minimum shifts.
				while((j>=gap) && nums[j-gap] >nums[j]) {
					swap(nums, j, j-gap);
					j=j-gap;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {12,-4,56,0,3,8,2,1};
		showArray(nums);
		shellSort(nums);
		showArray(nums);

	}
}
