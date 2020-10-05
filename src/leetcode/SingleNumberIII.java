/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author salipuri
 * 
 * Single Number III
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 */
public class SingleNumberIII {

	/**
	 * @param args
	 */
	
	public static int[] singleNumber(int[] nums) {
        
		int[] result = new int[2];
		HashSet<Integer> set = new HashSet<>();
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(Integer num: nums) {
			if(!set.contains(num)) {
				set.add(num);
			}else
				set.remove(num);
		}
		
		int i=0;
		for(Integer num:set) {
			result[i++] = num;
		}
		
		
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
