/**
 * 
 */
package firstFitProblem;

import java.util.Arrays;
import java.util.List;

/**
 * @author salipuri
 * 
 * Objects of different volumes must be packed into a finite number of bins or containers each of Volume V in a way
 * that minimizes the number of bins used. It is NP-complete problem.
 * In the main : how to fit several things into containers in an efficient way
 * When the number of bins is restricted to 1 & each item is characterized by both a volume and a value, the problem of maximizing
 * the value of items that can fit in the bin is known as knapsack problem
 * 
 * Solution:
 * 1.)Naive approach:	"brute force search"
 * 		-Iterate over all bins,try to put the current item in the bin & (if it fits) call the same method with next item
 * 2.)First-fit algorithm:
 * 		-Iterate over all the items we want to put into bins-> if we are not able to put it into a given bin, we try to put into next 1.
 * 		-Yields non optimal solution in the main.
 * 3.)First-fit decreasing algorithm:
 * 		-Sorting the items in decreasing order may be helpful . After sorting we use first-fit algo.
 * 		-Yields non optimal solution in the main.
 * 
 * Applications:
 * - We have N group of people with group size w1,w2...wN. We have minibuses with capacity C. What is the optimal no. of minibuses when the
 * 	 group must stay together?
 * -VMs of ten have to solve this problem.
 * -TV ads : we are given a certain time slot(eg:10 mins).How do we pack the most commercials into each time slot & maximize daily profits?
 *
 */
public class BinPackingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> items = Arrays.asList(10,5,5);
		
		int binCapacity =10;
		
		FirstFitDecreasingAlgo firstFitDecreasingAlgo = new FirstFitDecreasingAlgo(items, binCapacity);
		firstFitDecreasingAlgo.solveBinPacking();
		firstFitDecreasingAlgo.showResult();
	}

}
