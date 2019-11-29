/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * 
 * One of the most important problems in complexity theory
 * Problem: Given an S set of integers, is there a non empty subset whose s sum is zero or a given integer?
 * For example: Given a set {5,2,3,1} and s= 9...the answer is YES because the subset {5,3,1} sums to 9
 * NP-complete problem => we have efficient algos when problem is smaller
 * Special case of KNAPSACK
 * 
 * DP TABLE approach:
 * We dont want to calculate the same problems again and again so we create a DP table and memoize.
 * 
 * Non empty set of first i integers that sums to j
 * dpTable[i][j] = true if j=0 & false if i=0;
 * 				 = dpTable[i-1][j] if dpTable[i-1][j] is true
 * 				 = dpTable[i-1][j-S[i-1]]
 * 
 * if j-actualInteger can be constructed with i-1 integers	(EXCLUDE)
 * if j can be constructed with i-1 integers -> there must be a subset with sum i as well  (INCLUDE)
 *
 */
public class SubsetSumProblem {

	/**
	 * @param args
	 */
	
	private boolean[][] dpTable;
	private int sum;
	private int[] S;
	
	
	
	
	public SubsetSumProblem(int sum, int[] s) {
		super();
		this.sum = sum;
		S = s;
		this.dpTable = new boolean[S.length+1][sum +1];
	}

	public void solve(){
		//initialize
		for(int i=0;i<=S.length;i++) {
			dpTable[i][0] = true;
		}
		
		for(int j=0;j<=sum;j++) {
			dpTable[0][j] = false;
		}
		
		for(int rowIndex =1;rowIndex<=S.length;rowIndex++) {
			for(int colIndex = 1;colIndex<=sum;colIndex++) {
				if(colIndex<S[rowIndex-1]) {
					dpTable[rowIndex][colIndex] = dpTable[rowIndex-1][colIndex];
				}
				else {
					dpTable[rowIndex][colIndex] = dpTable[rowIndex][colIndex-S[rowIndex-1]];
				}
			}
			
		}
		System.out.println("Solution: "+dpTable[S.length][sum]);
		
	}
	
	
	
	public void showIntegers() {
		int colIndex = sum;
		int rowIndex = S.length;
		
		while(colIndex > 0 || rowIndex >0) {
			//System.out.println(rowIndex+"-"+colIndex+":"+S[rowIndex-1]);
			if(dpTable[rowIndex][colIndex] == dpTable[rowIndex-1][colIndex]) {
				rowIndex = rowIndex -1;
			}
			else {
				System.out.println("We take: "+ S[rowIndex-1]);
				colIndex = colIndex - S[rowIndex-1];
				rowIndex = rowIndex -1;
			}
			
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {5,2,3,1};
		int sum = 9;
		
		SubsetSumProblem subsetSumProblem = new SubsetSumProblem(sum, numbers);
		subsetSumProblem.solve();
		subsetSumProblem.showIntegers();
	}

}
