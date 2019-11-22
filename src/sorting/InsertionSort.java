/**
 * 
 */
package sorting;

/**
 * @author salipuri
 *
 *Example:
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 4 (last element of the array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13
 */
public class InsertionSort {

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
	
	public static void insertionSort(int[] nums) {
		
		for(int i=1;i<nums.length;i++) {
			int j =i;
			while(j>0 && (nums[j-1]>nums[j])) {
				swap(nums, j, j-1);
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {12,-4,56,0,3,8,2,1};
		showArray(nums);
		insertionSort(nums);
		showArray(nums);

	}

}
