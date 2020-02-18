/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author salipuri
 *
 */
public class FirstMissingPositive {

	/**
	 *
	
	Given an unsorted integer array, find the smallest missing positive integer.

	Example 1:

	Input: [1,2,0]
	Output: 3
	
	Example 2:
	Input: [3,4,-1,1]
	Output: 2
	
	Example 3:
	Input: [7,8,9,11,12]
	Output: 1
	Note:

	Your algorithm should run in O(n) time and uses constant extra space.
	*/
	
	public static int firstMissingPositive2(int[] nums) {
        int missingInt = 0;
		
		if(nums == null || nums.length == 0)
        	return 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int num: nums) {
			minHeap.add(num);
		}
		
		int top;
		while(true) {
			top = minHeap.poll();
			try {
				if(minHeap.peek() - top > 1) {
					missingInt = top +1;
					break;
				}
			}catch(NullPointerException e) {
				missingInt = top +1;
				break;
			}
		}
		
		return missingInt;
    }
	
	public static int firstMissingPositive(int[] nums) {
		
		int missingInt = 0;
		
		if(nums == null || nums.length == 0)
        	return 1;
		
		int max = Integer.MIN_VALUE;
		HashMap< Integer, Integer> map = new HashMap<>();
		
		for(int num:nums) {
			max = Math.max(max, num);
			map.put(num,0);
		}
		
		for(int i=1;i<=max;i++) {
			if(!map.containsKey(i)) {
				missingInt = i;
				break;
			}
				
		}
		
		if(missingInt == 0) {
			if(max > 0)
				missingInt = max +1;
			else
				missingInt = 1;
		}
		
		return missingInt;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] {-5};
		System.out.println(firstMissingPositive(array));
		
	}

}
