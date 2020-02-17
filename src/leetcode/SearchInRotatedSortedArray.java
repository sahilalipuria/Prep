/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 *
 *	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class SearchInRotatedSortedArray {

	/**
	 * @param args
	 */
	
	public static int search(int[] nums, int target) {
        
		int start = 0;
		int end = nums.length-1;
		int middle = 0;
		
		while(start<end) {
			middle = start + (end-start)/2;
			
			if(nums[middle]==target) {
				return middle;
			}
			if(nums[start]<=nums[middle]) {
				if(target>=nums[start] && target<=nums[middle])
					end = middle -1;
				else
					start = middle+1;
				
			}else {
				if(target > nums[middle] && target<=nums[end])
					start = middle +1;
				else
					end = middle -1;
			}
		}
		if(start == end && nums[end]==target)
			return end;
        else
            return -1;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = search(new int[] {4,5,6,7,0,1,2},3);
		System.out.println(result);

	}

}
