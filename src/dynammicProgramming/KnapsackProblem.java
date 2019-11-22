/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * 
 * It is a problem in combinatorial optimization
 * Given a set of items, each with a mass w & value v,determine the number of each item to include in a collection
 * so that the total weight M is less than or equal to a given limit & total value is as large as possible.
 * The problem often arises in resource allocation where there are financial constraints
 * 
 * APPLICATIONS:
 * Has lot of applications of course
 * Finding the least wasteful way to cut raw materials
 * Selection of Investments & portfolios
 * Selection of assets for asset-backed secularization
 * Construction & scoring of tests in which the test-takers have a choice as to which question they answer.
 * 
 * Divisible Problem:
 * If we can take fractions of the given items,then the greedy approach can be used.
 * Sort the items according to their values,it can be done in O(NlogN) time complexity.
 * Start with the item that is the most valuable and take as much as possible 
 * Than try with the next item from our sorted list.
 * This linear search has O(N) time complexity
 * Overall: O(NlogN) + O(N) = O(NlogN)!!!!
 * So we can solve the divisible knapsack problem quite fast!!!!!!
 * 
 * 0-1 Knapsack Problem:
 * In this case we are not able to take fractions: we have to decide whether to take an item or not
 * Greedy algo will not provide optimal result
 * Another approach would be to sort by cost per unit weight and include from highest on down until knapsack is full....not a good solution too!!!
 * -DP is the right way
 * 
 * DP approach:
 * We have to define subproblems: we have N items so we have to make N decisions whether to take the item with given index or not.
 * -The subproblems: the solution considering every possible combination of remaining items & remaining weight
 * S[i][w] the solution to the subproblem corresponding to the first i items and available weight w
 * - Or in other words
 * S[i][w]= the maximum cost of items that fit inside a knapsack of size(weight) w,choosing from the first i items!!!!
 * -We have to decide whether to take that item or not.
 * 
 * S[i][w] = Math.max(  			S[i-1][w];         v(i)+S[i-1][w-w(i)])
 *							do not take iTH item		we take iTH item
 *
 *BUT !!!! we are only considering S[i-1][w-w(i)] if it can fit w >= w(i). If there is no room for it answer is just S[i-1][w]!!!!!!
 *
 *Time complexity:
 *Running time : O(n*w)
 *But it is not polynomial; it is pseudo polynomial
 *Numeric algorithm runs in pseudo polynomial time if its running time is polynomial in its numeric value,but is exponential in the length of the input
 *(number of bits required to represent it)
 */
public class KnapsackProblem {

	/**
	 * @param args
	 */
	
	private int numOfItems;
	private int capacityOfKnapsack;
	private int[][] knapsackTable;
	private int totalBenefit;
	private int[] weights;
	private int[] values;
	
	
	
	public KnapsackProblem(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
		super();
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.weights = weights;
		this.values = values;
		this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
	}
	
	public void solve() {
		for(int i=1;i<numOfItems+1;i++) {
			for(int w=1;w<capacityOfKnapsack+1;w++) {
				int notTakingItem = knapsackTable[i-1][w];		// not taking item i
				int takingItem = 0;
				if(weights[i]<=w) {
					takingItem = values[i]+knapsackTable[i-1][w-weights[i]];
				}
				
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
			}
		}
		totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
	}
	
	public void showResults() {
		System.out.println("Total benefit: "+ totalBenefit);
		for(int n=numOfItems,w=capacityOfKnapsack;n>0;n--) {
			if(knapsackTable[n][w]!=0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
				System.out.println("We take item: "+n);
				w=w-weights[n];
			}
		}
		
	}



	public static void main(String[] args) {
		int numOfItems = 3;
		int capacityOfKnapsack = 5;
		
		int[] weightOfItems = new int[numOfItems+1];
		weightOfItems[1] = 4;
		weightOfItems[2] = 2;
		weightOfItems[3] = 3;
		
		int[] profitOfItems = new int[numOfItems+1];;
		profitOfItems[1] = 10;
		profitOfItems[2] = 4;
		profitOfItems[3] = 7;
		
		KnapsackProblem knapsackProblem = new KnapsackProblem(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
		knapsackProblem.solve();
		knapsackProblem.showResults();

	}

}
