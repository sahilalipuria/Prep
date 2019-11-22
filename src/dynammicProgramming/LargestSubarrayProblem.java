/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 *
 *Applications:
 *-Computer vision: to detect brightness area in image. Crucial in Haar-features,deep learning and self driving cars
 *-Geonomic sequence analysis - we can identify important segments of protein sequences and the information to be able to predict outcome.
 *-data mining - largest subarray is important when dealing with association rules and forseeing customer's behaviour.
 *
 *Kadane’s Algorithm to solve in O(n):
 *Approach: if we know B(i) max subarray ending at index i then what is the B(i+1) max subarray sum ending at index i+1
 *			Either the max sum ending at index i+1 includes the max subarray ending at index i OR it doesn't.
 *			B(i+1) = Max(nums[i+1],B(i)+nums[i+1]);
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
Explanation:
Simple idea of the Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). 
And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 */
public class LargestSubarrayProblem {

	/**
	 * @param args
	 */
	
	public int kadaneAlgo(int[] nums) {
		
		
		//Initialize the algorithm with the first item in the array
		int max_global = 0;
		int max_current = 0;
		
		//It has O(N) linear running time complexity
		for(int i=1;i<nums.length;i++) {
			
			max_current = Math.max(nums[i], max_current+nums[i]);
			
			if(max_current > max_global) {
				max_global = max_current;
			}
		}
		
		return max_global;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LargestSubarrayProblem largestSubarrayProblem = new LargestSubarrayProblem();
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Maximum contiguous sum is " +largestSubarrayProblem.kadaneAlgo(a));
	}

}
