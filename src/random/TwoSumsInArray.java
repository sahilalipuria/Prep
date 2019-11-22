/**
 * 
 */
package random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author salipuri
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 *
 */
public class TwoSumsInArray {

	/**
	 * @param args
	 */

	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		if(nums[i]+nums[j]==target) {
        			indices[0]=i;
        			indices[1]=j;
        			break;
        		}
        	}
        }
        return indices;
    }
	
	public int[] twoSumOptimized(int[] nums,int target) {
		int[] indices = new int[2];
		HashMap<Integer,Integer> hashTable = new HashMap();
		
		for(int i=0;i<nums.length;i++) {
			if(hashTable.containsKey(target-nums[i])) {
				indices[0] = hashTable.get(target-nums[i]);
				indices[1] = i;
				break;
			}else {
				hashTable.put(nums[i], i);
			}
		}
		
		return indices;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-1,-2,-3,-4,-5};
		TwoSumsInArray twoSumsInArray = new TwoSumsInArray();
		System.out.println(twoSumsInArray.twoSumOptimized(nums, -8)[0]);
		System.out.println(twoSumsInArray.twoSumOptimized(nums, -8)[1]);

	}

}
