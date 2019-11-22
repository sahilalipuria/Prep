package recursion;

/**
 * @author salipuri
 *
 *	Also known as Hoare algorithm
 *	Running time: O(N) best case and O(N^2) in worst case(if we are not able to discard many items)
 *
 *	In order to make sure the running time is O(N) we keep discarding half of array in every iteration
 *	How? We pick a good "pivot" . If we pick median as pivot then items on left and right of pivot will be the same
 *	It is approx pivot but enough to make sure we discard more items.
 *
 *	MEDIAN OF MEDIANS select:
 *		we calculate approx median
 *		O(N) running time guaranteed
 *		O(logN) worstcase memory complexity
 *
 *	Introselect:	It is the combination of quick select and median of medians select. 
 *					It begins with quickselect algo but reverts to median of medians if the progress is too slow
 *
 *	SECRETARY PROBLEM (Online Selection Algo/Best choice problem):
 *	-We want to find kth smallest/largest item of stream. Partition based algo can't be used as dont know the data in advance.
 *	-The problem is to select(under constraints) a specific element of input sequence of data with largest probability
 *	-Very important problem of optimal stopping theory
 *	-PROBLEM: We want to hire best secretary out of N applicants. Applicants are interviewed one by one+ after rejection they cant be recalled
 *			  We rank the applicants among all the applicants interviewed so far,but we are unaware of quality of yet unseen ones
 *			  What is optimal startegy:  We want to maximize the probability of selecting the best candidate
 *	-If we can make decision at the end: we have to make a max finding. It can be done in O(N)...no problem but we have to decide immediately.
 *	-SOLUTION:	Always reject n/e applicants & then we have to stop at the one who is better than the previous ones. e: natural log~2.718...
 *				it is very popular problem as it has a well defined solution
 *	-Probability of choosing the best candidate is 1/e
 *	-so 37% chance we find the optimal one.
 *		
 */

import java.util.Random;

public class QuickSelectAlgo {
	
	private static int[] nums;
	private static double e = 2.71828;
	
	public QuickSelectAlgo(int[] nums) {
		this.nums = nums;
	}
	
	public static int select(int k) {
		return select(0,nums.length-1,k-1);
	}
	
	public static void swap(int i,int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]= temp;
	}
	
	private static int select(int firstIndex,int lastIndex,int k) {
		int pivot = partition(firstIndex,lastIndex);
		if(pivot>k) {
			return select(firstIndex,pivot-1,k);
		}else if(pivot<k) {
			return select(pivot+1,lastIndex,k);
		}
		return nums[k];
	}
	
	private static int partition(int firstIndex, int lastIndex) {
		int pivot = new Random().nextInt(lastIndex-firstIndex+1)+firstIndex;
		
		swap(lastIndex,pivot);
		
		for(int i=firstIndex;i<lastIndex;i++) {
			if(nums[i]>nums[lastIndex]) {				//Reverse it to find the smallest
				swap(i,firstIndex);
				firstIndex++;
			}
		}
		
		swap(firstIndex,lastIndex);
		
		return firstIndex;				//Pivot element
		
	}
	
	private static int roundNo(float num) 
	{ 
	    return (int) (num < 0 ?  
	                  num - 0.5 : num + 0.5); 
	} 
	
	// Finds best candidate using n/e rule. candidate[] 
	// represents talents of n candidates. 
	private static void printBestCandidate(int candidate[], int n) 
	{ 
	    // Calculating sample size for benchmarking. 
	    int sample_size = roundNo((float) (n / e)); 
	    System.out.println("\n\nSample size is " + sample_size); 
	  
	    // Finding best candidate in sample size 
	    int best = 0;  
	    for (int i = 1; i < sample_size; i++) 
	        if (candidate[i] > candidate[best]) 
	            best = i; 
	  
	    // Finding the first best candidate that is  
	    // better than benchmark set. 
	    for (int i = sample_size; i < n; i++) 
	        if (candidate[i] >= candidate[best]) 
	        { 
	            best = i; 
	            break; 
	        } 
	  
	    if (best >= sample_size) 
	        System.out.println("\nBest candidate found is " +  
	                           (best + 1) + " with talent " +  
	                            candidate[best]); 
	    else
	        System.out.print("Couldn't find a best candidate\n"); 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[]= {1,5,4,8,-2};
		
		for(int i: nums) {
			System.out.print(i+" ");
		}
		System.out.println();
		QuickSelectAlgo quickSelect = new QuickSelectAlgo(nums);
		
		System.out.println(select(2));
		
		System.out.println("========NOW ONLINE SECRATARY PROBLEM=================");
		
		//ONLINE SECRATARY PROBLEM MAIN
		
		int n = 8; 
		  
	    // n = 8 candidates and candidate array contains 
	    // talents of n candidate where the largest  
	    // number means highest talented candidate. 
	    int []candidate = new int[n]; 
	  
	    // generating random numbers between 1 to 8  
	    // for talent of candidate 
	    Random rand = new Random(); 
	    for (int i = 0; i < n; i++) 
	        candidate[i] = 1 + rand.nextInt((8 - 1) + 1); 
	  
	    System.out.print("Candidate : "); 
	    for (int i = 0; i < n; i++) 
	        System.out.print(i + 1 + " "); 
	    System.out.println(); 
	    System.out.print("Talents : "); 
	    for (int i = 0; i < n; i++) 
	        System.out.print(candidate[i] + " "); 
	      
	    printBestCandidate(candidate, n); 

	}

}
