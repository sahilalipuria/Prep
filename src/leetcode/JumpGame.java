/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	
	public static boolean canJump(int[] nums) {
		boolean result = false;

		if (nums.length == 0)
			return result;
		else if (nums.length == 1)
			return true;

		if (nums[0] == 0)
			return result;

		int[] dpTable = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dpTable[i] = -1;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			int j = nums[i];
			while (j > 0) {
				if (i + j < nums.length)
					dpTable[i + j] = i;

				j--;
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (dpTable[i] == -1)
				return false;
		}

		if (dpTable[nums.length - 1] != -1)
			result = true;

		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
		System.out.println(canJump(new int[] {0}));
		System.out.println(canJump(new int[] {0,2,3}));
		System.out.println(canJump(new int[] {1,0,1,0}));
		
	}

}
