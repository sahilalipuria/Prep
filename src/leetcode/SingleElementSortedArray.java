/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
 *
 */
public class SingleElementSortedArray {

	/**
	 * @param args
	 */
	
	public static int singleNonDuplicate(int[] nums) {
        
        int i=0;
        
        if(nums.length > 1){
            while(i<nums.length && (i+1)!=nums.length){
                if(nums[i] ==nums[i+1])
                    i+=2;
                else
                    break;
            }   
        }
        
        return nums[i];
    }
	
	public static void main(String[] args) {
		
		System.out.println(singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
		System.out.println(singleNonDuplicate(new int[] {1,1,2}));
		System.out.println(singleNonDuplicate(new int[] {1}));
		

	}

}
