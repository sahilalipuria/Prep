/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	
	public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        HashMap<Integer,Integer> numbersMap = new HashMap<Integer,Integer>();
        for(int num: nums)
            numbersMap.put(num,numbersMap.getOrDefault(num,0)+1);
        
        for(int key: numbersMap.keySet()){
            if(numbersMap.get(key) == 1)
                return key;
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] {4,1,2,1,2};
		int result = singleNumber(nums);
		
		System.out.println(result);
		
	}

}
