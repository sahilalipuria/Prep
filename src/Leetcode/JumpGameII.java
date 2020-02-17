/**
 * 
 */
package leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
 *
 */
public class JumpGameII {

	/**
	 * @param args
	 */
	public static int jump(int[] nums) {
		int[] jumpArray = new int[nums.length];
		for(int i=0;i<jumpArray.length;i++) {
			jumpArray[i] = Integer.MAX_VALUE;
		}
		jumpArray[0] = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=1;j<= nums[i];j++) {
				if(i+j<nums.length)
					jumpArray[i+j] = Math.min(jumpArray[i+j], i);
			}
		}
		return calculateCount(jumpArray);
    }
	
	
	private static int calculateCount(int[] jumpArray) {
		int i=jumpArray.length-1;
		int count=0;
		while(i>0) {
			i=jumpArray[i];
			count++;
		}
		return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{2,3,1,1,4};
		int result = jump(array);
		System.out.println(result);
	}

}
