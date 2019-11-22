/**
 * 
 */
package random;

import java.util.Random;

/**
 * @author salipuri
 * 
 * Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items, where n is either a very large or unknown number. Typically n is large enough that the list doesn’t fit into main memory. For example, a list of search queries in Google and Facebook.

So we are given a big array (or stream) of numbers (to simplify), and we need to write an efficient function to randomly select k numbers where 1 <= k <= n. Let the input array be stream[].

A simple solution is to create an array reservoir[] of maximum size k. One by one randomly select an item from stream[0..n-1]. If the selected item is not previously selected, then put it in reservoir[]. 
To check if an item is previously selected or not, we need to search the item in reservoir[]. The time complexity of this algorithm will be O(k^2). This can be costly if k is big. Also, this is not efficient if the input is in the form of a stream.



It can be solved in O(n) time. The solution also suits well for input in the form of stream. The idea is similar to this post. Following are the steps.

1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
2) Now one by one consider all items from (k+1)th item to nth item.
…a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
 *
 */
public class ReservoirSamplingProblem {

	/**
	 * @param args
	 */
	
	private Random random;
	
	public ReservoirSamplingProblem() {
		this.random = new Random();
	}
	
	//O(N) algorithm to get k items at random from array nums
	public void solve(int[] nums,int k) {
		
		//create a new array for k items
		int[] reservoir = new int[k];
		
		//copy the first k items from original array
		for(int i=0;i<reservoir.length;i++) {
			reservoir[i] = nums[i];
		}
		
		//We consider the items from the original array
		//k+1 because we have already copied k items
		//the i-th item is chosen to be included in the reservoir with the probability k/i
		for(int i=k+1;i<nums.length;i++) {
			int j=random.nextInt(i)+1;
			if(j<k) reservoir[j] = nums[i];
		}
		
		//show the k random items
		for(int i=0;i<reservoir.length;i++) {
			System.out.println(reservoir[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; 
        int k = 5; 
        
        ReservoirSamplingProblem reservoirSamplingProblem = new ReservoirSamplingProblem();
        reservoirSamplingProblem.solve(nums, k);

	}

}
