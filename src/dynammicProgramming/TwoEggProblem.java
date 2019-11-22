/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * 
 * Given two eggs, find the highest floor an egg can be dropped from without breaking, with as few drops as possible.
 * 
 * 1st approach - linear from bottom
 * 2nd approach - If many eggs then binary search
 * 3rd approach - 
 * 	Lets suppose we drop first egg from floor n:
 * 		- If it breaks we can do linear search through previous n-1 floors
 * 		- If it doesn't break then we jump up n floors but we should take previous drops in consideration
 * 
 * 	That's y jump up n-1 floors instead of n. In next iteration we jump n-2 floors and so on.
 * 
 * 	Finally we consider all the floors so we keep reducing the steps.
 * 	n + (n-1) + (n-2) +..........+1 = 100
 * 		n(n+1)/2 = 100		=> n = 13.7(14 drops)
 * 
 * 	min							{max(drop(n-1,x-1),drop(n,m-x))}
 * we want min drops			eggs break after droping from x,egg doesnt break after dropping from floor x
 *
 */
public class TwoEggProblem {

	/**
	 * @param args
	 */
	
	static final int NUM_OF_EGGS = 2;
	static final int NUM_OF_FLOORS = 100;
	
	private int[][] dpTable = new int[NUM_OF_EGGS+1][NUM_OF_FLOORS+1];
	
	
	public int solve() {
		
		//From first floor
		dpTable[0][0] = 1;			//0 egg drop
		dpTable[1][0] = 1;			//1 egg drop
		
		//Requires linear search for 1 egg
		for(int i=0;i<NUM_OF_FLOORS;i++) {
			dpTable[1][i] = i;
		}
		
		//n is for the eggs and m is for floors
		for(int n=2;n<=NUM_OF_EGGS;n++) {
			for(int m=1;m<=NUM_OF_FLOORS;m++) {
				dpTable[n][m] = Integer.MAX_VALUE;
				
				// check dropping egg from 1 to current floor m.NOTE: We can reuse the subsolution from the table!!!
				for(int x=1;x<=m;x++) {
					int maxDrops = 1+Math.max(dpTable[n-1][x-1], dpTable[n][m-x]);
					
					if(maxDrops<dpTable[n][m]) {
						dpTable[n][m] = maxDrops;
					}
				}
				
			}
		}
		
		return dpTable[NUM_OF_EGGS][NUM_OF_FLOORS];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TwoEggProblem twoEggProblem = new TwoEggProblem();
		System.out.println(twoEggProblem.solve());

	}

}
