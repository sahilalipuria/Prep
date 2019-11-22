/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 *
 *Given a rod with certain lengths
 *Given the prices of different lengths
 *How to cut the rod for maximum profits?
 *this is rod cutting problem
 *
 *Recursion approach:
 *N-1 cuts can be made in the rod of length N
 *2^(n-1) ways to cut the rod
 *Problem : time complexity + overlapping subproblems
 *Exponential time complexity : O(2^n) where n is the length of rod in units
 *(for every length we have option to cut it or not)
 *
 *DP approach:
 *We have to create a solution matrix:
 *	dpTable[numOfLengths+1][originalLength+1]
 *
 *We have to define the base case:
 *	- if the original length is 0 -> 0 is the profit.
 *	- if we dont consider any lengths -> 0 is the profit
 *
 *Complexity: O(numOfLengths * originalLength)
 *
 *dpTable[i][j] =  0 if j=0 & 0 if i = 0
 *				=  max { dpTable[i-1][j] ; price[i]+ dpTable[i][j-1]	} if i<=1
 *				=		dpTable[i-1][j] if i>j											Total value when total length is j & we have first i pieces
 *
 *If the piece is greater than length of rod we skip it.
 */
public class RodCuttingProblem {

	/**
	 * @param args
	 */
	
	private int[][] dpTable;
	private int lengthOfRod;
	private int[] prices;
	
	
	
	public RodCuttingProblem(int lengthOfRod, int[] prices) {
		this.lengthOfRod = lengthOfRod;
		this.prices = prices;
		this.dpTable = new int[prices.length+1][lengthOfRod+1];
	}
	
	public void solve() {
		
		//initialize
		
		for(int i=1;i<prices.length;i++) {
			for(int j=1;j<=lengthOfRod;j++) {
				if(i<=j) {
					dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i]+dpTable[i-1][j-i]);
				}
				else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
		
	}
	
	public void showResult() {
		System.out.println("Optimal Profit: $"+dpTable[prices.length-1][lengthOfRod]);
		
		for(int n= prices.length-1,w=lengthOfRod;n>0;) {
			if(dpTable[n][w]!=0 && dpTable[n][w]!=dpTable[n-1][w]) {
				System.out.println("We made a cut: "+n+"m");
				w= w-n;
			}
			else {
				n--;
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lengthOfRod = 5;
		int[] prices = {0,2,5,7,3};
		
		RodCuttingProblem rodCuttingProblem = new RodCuttingProblem(lengthOfRod, prices);
		rodCuttingProblem.solve();
		rodCuttingProblem.showResult();
	}

}
