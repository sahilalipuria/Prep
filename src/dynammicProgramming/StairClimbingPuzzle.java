/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 *Objective: A child is climbing up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
 *Implement a method to count how many possible ways the child can jump up the stairs.

Example:

Number of stairs : 3

Number of ways = 4 ( {1,1,1}, {1,2}, {2,1}, {3} )
 */
public class StairClimbingPuzzle {

	/**
	 * @param args
	 */
	
	private int[] dpTable;
	private int numOfStairs;
	private int maxSkips;
	
	
	
	public StairClimbingPuzzle(int numOfStairs,int maxSkips) {
		super();
		this.numOfStairs = numOfStairs;
		this.maxSkips = maxSkips;
		this.dpTable = new int[numOfStairs+1];
	}
	
	public void solve() {
		
		dpTable[0] = 1;
		dpTable[1] = 1;
		
		for(int i=2;i<=numOfStairs;i++) {
			dpTable[i] = 0;
			for(int j=1;j<=i && j<=maxSkips;j++) {
				dpTable[i] += +dpTable[i-j];
			}
		}
	}
	
	public void showResults() {
		System.out.println("Ways to reach each stair:");
		for(int i=1;i<=numOfStairs;i++) {
			System.out.println(i+"stair -"+dpTable[i]);
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StairClimbingPuzzle stairClimbingPuzzle = new StairClimbingPuzzle(4, 3);
		stairClimbingPuzzle.solve();
		stairClimbingPuzzle.showResults();

	}

}
