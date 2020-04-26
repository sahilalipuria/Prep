/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 */
public class SubarraySumEqualsK {

	/**
	 * @param args
	 */
	
	public static int subarraySum2(int[] nums, int k) {
        int result = 0;
        int index = 0;
        
        if(nums.length == 0)
        	return result;
        
        int[] sumArray = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
        	if(i==0)
        		sumArray[i] = nums[i];
        	else
        		sumArray[i] = sumArray[i-1] + nums[i];
        	
        	//System.out.println(sumArray[i]+"-"+sumArray[index]);
        	if(nums[i] == k) {
        		result++;
        		index = i+1;
        	}
			if (sumArray[i] == k) {
				result++;
				index++;
			}
			for (int j = index; j < i; j++) {
				System.out.println(sumArray[i] + "--" + sumArray[j]);
				if (sumArray[i] - (sumArray[j] - nums[j]) == k) {
					result++;
					index = j;
				}
			}
        	
        }
        System.out.println("-------------");
        return result;
    }
	public static int subarraySum(int[] nums, int k) {
		
		int result = 0;
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		
		for(int i=0;i<nums.length;i++) {
			
			sum += nums[i];
			
			if(sum == k)
				result++;
			
			if(sumMap.containsKey(sum - k)) {
				result += sumMap.get(sum - k);
			}
			
			Integer count = sumMap.get(sum);
			if(count == null)
				sumMap.put(sum,1);
			else
				sumMap.put(sum,count+1);
			
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(subarraySum(new int[] {1,1,1},2));
		System.out.println(subarraySum(new int[] {1,2,3},3));
		System.out.println(subarraySum(new int[] {3,2,1},3));
		System.out.println(subarraySum(new int[] {1,1,1,1},2));
		System.out.println(subarraySum(new int[] {-1,-1},1));
		System.out.println(subarraySum(new int[] {0,0,0,0,0,0,0,0,0,0},0));
		
		
	}

}
