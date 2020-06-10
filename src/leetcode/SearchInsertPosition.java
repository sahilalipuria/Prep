/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 35. Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 *
 */
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	
	public static int searchInsert(int[] nums, int target) {
        
        int index=-1;
        
        if(target<=nums[0])
            return 0;
        
        if(target>nums[nums.length-1])
            return nums.length;
        else if(target==nums[nums.length-1])
            return nums.length-1;
        
        int start = 0;
        int end = nums.length-1;
        int middle;
        
        while(start<end){
            middle = start + (end-start)/2;
            if(target>nums[middle]){
                if(target>nums[middle+1])
                    start = middle+1;
                else{
                    index = middle+1;
                    break;
                }
            }else if(target<nums[middle]){
                if(target<=nums[middle-1])
                    end = middle-1;
                else{
                    index = middle;
                    break;
                }
            }
            else{
                index = middle;
                break;
            }
        }
        
        return index;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2));

	}

}
