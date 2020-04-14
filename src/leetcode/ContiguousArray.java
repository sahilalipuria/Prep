/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class ContiguousArray {

	/**
	 * @param args
	 */
	
	public static int findMaxLength(int[] nums) {
        int length = 0;
        int sum = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                sum--;
            else
                sum++;
            
            if(map.containsKey(sum)){
            	length = Math.max(length,i-map.get(sum));
            }else{
            	map.put(sum,i);
            }
        }
        
        return length;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
	}

}
