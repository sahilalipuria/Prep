/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 */
public class MaxSumContiguousSubArray {

	/**
	 * @param args
	 */
	
	
	
	public static int maxSubArray(int[] nums) {
        int current_max = nums[0];
        int max_so_far = nums[0];
        
        for(int i = 1;i<nums.length;i++){
            current_max = Math.max(nums[i],current_max + nums[i]);
            max_so_far = Math.max(current_max,max_so_far);
        }
        
        return max_so_far;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
