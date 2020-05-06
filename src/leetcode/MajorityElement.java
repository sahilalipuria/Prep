/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	
	public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        int result = Integer.MIN_VALUE;
        
        for(int num: nums){
            int temp = numMap.getOrDefault(num,0)+1;
            numMap.put(num,temp);
            if(temp >(nums.length/2)){
                result = num;
                break;
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(majorityElement(new int[] {3,2,3}));
		System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
	}

}
