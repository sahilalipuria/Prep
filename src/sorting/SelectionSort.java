/**
 * 
 */
package sorting;

/**
 * @author salipuri
 *
 */
public class SelectionSort {

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
	
	public static void selectionSort(int[] nums) {
		
		for(int i=0;i<nums.length-1;i++) {
			int index =i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[index]) {
					index = j;
				}
			}
			if(index!=i) {
				swap(nums, i, index);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {12,-4,56,0,3,8,2,1};
		showArray(nums);
		selectionSort(nums);
		showArray(nums);
	}

}
