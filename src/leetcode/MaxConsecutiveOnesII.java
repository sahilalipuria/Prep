/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 *
 */
public class MaxConsecutiveOnesII {

	/**
	 * @param args
	 */
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		
		int result = 0;
		
		if(nums.length==0)
			return result;
		
		int currentCount = 0;
		int previousCount = 0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) {
				currentCount++;
			}else {
				result = Math.max(result, previousCount+1+currentCount);
				previousCount = currentCount;
				currentCount = 0;
			}
		}
		if(previousCount!=0)
			result = Math.max(result, previousCount+1+currentCount);
		else
			result = Math.max(result, currentCount);
		
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
		System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
		System.out.println(findMaxConsecutiveOnes(new int[] {1}));
		System.out.println(findMaxConsecutiveOnes(new int[] {0}));
	}

}
