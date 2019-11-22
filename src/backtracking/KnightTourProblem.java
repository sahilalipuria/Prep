/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 * 
 * -A sequence of moves of a knight on a chessboard such that the knight visits every square exactly ONCE
 * -Closed Tour: when the knight visits the starting point.
 * -It is an instance of Hamiltonian problem
 * -Solution: Brute Force + Backtracking!!!!
 * 
 * Schwenk Theorem:
 * -For an mxn chessboard,the closed knight tour is always feasible,unless:
 * 	m & n are both odds
 * 	m = 1,2 or 4
 * 	m=3 & n=4,6,8
 * 
 * Backtracking:
 * -Start with an empty solution matrix			//2D ARRAY
 * -When adding a new item -> we check whether adding the current item violates the problem constraints or not
 * -If yes then backtrack else consider it.
 * 
 *
 *P.S: If you go left or downwards its -ve & vice versa
 */
public class KnightTourProblem {

	/**
	 * @param args
	 */
	
	private int[][] solutionMatrix;
	private int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
	private int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
	private static final int BOARD_SIZE = 8;
	private static final int NUM_OF_MOVES = 8;
	
	public KnightTourProblem() {
		this.solutionMatrix = new int[BOARD_SIZE][BOARD_SIZE];
		initializeBoard();
	}
	
	
	
	public void initializeBoard() {
		for(int i=0;i<BOARD_SIZE;i++) {
			for(int j=0;j<BOARD_SIZE;j++) {
				solutionMatrix[i][j] = Integer.MIN_VALUE;
			}
		}
	}
	
	public void solveTour() {
		solutionMatrix[0][0] = 1;
		
		if(solve(2,0,0)) {
			printSolution();
		}
		else {
			System.out.println("NO SOLUTION FOUND...");
		}	
	}



	private void printSolution() {
		// TODO Auto-generated method stub
		for(int i=0;i<BOARD_SIZE;i++) {
			for(int j=0;j<BOARD_SIZE;j++) {
				System.out.print(" "+solutionMatrix[i][j]);
			}
			System.out.println();
		}
		
	}



	private boolean solve(int stepCount, int x, int y) {
		// TODO Auto-generated method stub
		if(stepCount == BOARD_SIZE*BOARD_SIZE+1) {
			return true;
		}
		
		for(int i=0;i<NUM_OF_MOVES;i++) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			
			if(isStepValid(nextX,nextY)) {
				solutionMatrix[nextX][nextY] = stepCount;
				
				if(solve(stepCount+1, nextX, nextY)) {
					return true;
				}
				//BACKTRACK
				solutionMatrix[nextX][nextX] = Integer.MIN_VALUE;
			}
		}
		
		return false;
	}



	private boolean isStepValid(int x, int y) {
		if(x<0 || x>=BOARD_SIZE)
			return false;
		if(y<0 || y>=BOARD_SIZE) {
			return false;
		}
		if(solutionMatrix[x][y]!=Integer.MIN_VALUE) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		KnightTourProblem knightTourProblem = new KnightTourProblem();
		knightTourProblem.solveTour();
	}

}
