/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 *
 *	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {

	/**
	 * @param args
	 */
	
	public static void moveZeroes(int[] nums) {
        int index = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                System.out.println(nums[index]);
                index++;
            }
        }
        
        for(int i=index;i<nums.length;i++){
            nums[i] = 0;
            System.out.println(nums[i]);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		moveZeroes(new int[] {0,1,0,3,12});
	}

}
