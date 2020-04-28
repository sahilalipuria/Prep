/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author salipuri
 * 
 * Given an numsay nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the numsay which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given numsay nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 *
 */
public class ThreeSum {

	/**
	 * @param args
	 */
	
	public static List<List<Integer>> threeSum(int[] nums) {
        
		Arrays.sort(nums);
		 
	    ArrayList<List<Integer>> result = new ArrayList<>();
	 
	    for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
	 
	        while (j < k) {
	            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
	                k--;
	                continue;
	            }
	 
	            if (nums[i] + nums[j] + nums[k] > 0) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < 0) {
	                j++;
	            } else {
	                ArrayList<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
	 
	    return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));

	}

}
