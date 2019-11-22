/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * 
 * Given a set of coins v[] for example (1,2,3} and Given an amount M->the total
 * How many ways the coins v[] can be combined in order to get the total M?
 * The order of coins doesn't matter!!!!
 * This is the coin change problem
 * 
 * For eg:
 * Coins v[] -> {1,2,3}
 * Total amount M -> 4
 * 
 * Solution to the coin change problem -> {1,1,1,1} {1,1,2} {1,3} {2,2}. The order doesn't matter {1,3} = {3,1}
 * 
 * DP:
 * We have to create a solution matrix + dpTable[numOfCoins+1][totalAmount+1]
 * We have to define the base cases:
 * 		-if the totalAmount is 0 -> there is 1 way to make the change because we dont include any coin!!!!
 * 		-if the numOfCoins is 0 -> there is 0 way to change amount. In this case there is no solution!!!!
 * Complexity: O(v*M)
 * For every coin: make a decision whether to include it or not. Check if the coin value is less than or equal to the amount needed.
 * 
 * If yes-> then we will find ways by including the coin and excluding it.
 * 
 * 1.) Include the coin: reduce the amount by coin value & use the subproblem. Solution: totalAmount -v[i]
 * 2.) Exclude the coin: solution for the same amount without considering that coin.	
 * 	
 * 0 if i=0 and 1  if j=0
 * dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]]       if v[i]<=j
 * 				 = dpTable[i-1][j]								if v[i]>j
 * 
 * What does it mean simply? If the given v[i]> j-> copy the content of box above the current else 
 * 							dpTable[i][j] = value of box above the current + (value in same row -v[i])
 *
 */
public class CoinChangeProblem {

	/**
	 * @param args
	 */
	
	public int naiveCoinChange(int M,int[] v, int index) {
		
		if(M<0 )
			return 0;
		
		if(M==0)
			return 1;
		
		if(v.length==index)
			return 0;
		
		return (naiveCoinChange(M-v[index], v, index)+naiveCoinChange(M, v, index+1));			// 2 possibilities: include / exclude the coin
		
	}
	
	public void dynamicProgrammingCoinChange(int[]v ,int M) {
		int[][] dpTable = new int[v.length+1][M+1];
		
		for(int i=0;i<=v.length;i++) {
			dpTable[i][0] = 1;
		}
		
		for(int j=1;j<=M;j++) {
			dpTable[0][j] =0;
		}
		
		//O(v*M)
		for(int i=1;i<=v.length;i++) {
			for(int j=1;j<=M;j++) {
				
				if(v[i-1]<=j) {
					dpTable[i][j] = dpTable[i-1][j]+ dpTable[i][j-v[i-1]];
				}
				else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
		System.out.println("Solution: "+dpTable[v.length][M]);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] v = {1,2,3};
		int M = 4;
		
		CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
		coinChangeProblem.dynamicProgrammingCoinChange(v, M);

	}

}
