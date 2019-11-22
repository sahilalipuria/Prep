/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 *
 *Aim of sudoku is to fill 9x9 chessboard-like grid with digits.
 *RULES:
 *Each column and each row of each 3*3  subgrids that compose the grid(boxes) contains all of the digits from 1 to 9
 *Initially we have -> a partially filled grid,which for a well posed puzzle has a unique solution
 *Some integer may cant appear twice in same row/column or in any of 3x3 grids subregion/boxes of 9*9 grid
 *NP complete problem
 *Runtime complexity : O(m^n) where m is number of possibilities for a cell and n is total empty fields in beginning.
 *
 *BACKTRACKING:
 *Iterates over all the posibilities for given soduku
 *If solution assigned dont lead to the solution,the algo discards the solution and rollbacks to the original solutions & retires again.
 */
public class SudokuProblem {

	/**
	 * @param args
	 */
	
	private static final int BOARD_SIZE = 9;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int BOX_SIZE = 3;
	
	private int[][] sudokuTable;
	
	public SudokuProblem(int[][] sudokuTable) {
		this.sudokuTable = sudokuTable;
	}
	
	public void solveProblem() {
		if(solve(0,0)) {
			printTable();
		}
		else {
			System.out.println("NO SOLUTION FOUND");
		}
	}
	
	private boolean solve(int rowIndex, int colIndex) {
		if(rowIndex == BOARD_SIZE && ++colIndex==BOARD_SIZE) {
			return true;
		}
		
		if(rowIndex == BOARD_SIZE) {
			rowIndex = 0;
		}
		
		if(sudokuTable[rowIndex][colIndex]!=0) {
			return solve(rowIndex+1,colIndex);
		}
		
		for(int number=MIN_NUMBER;number<=MAX_NUMBER;number++) {
			if(valid(rowIndex,colIndex,number)) {
				sudokuTable[rowIndex][colIndex] = number;
				if(solve(rowIndex+1, colIndex)) {
					return true;
				}
				
				//BACKTRACK
				sudokuTable[rowIndex][colIndex] =0;
			}
		}
		
		return false;
	}

	private boolean valid(int rowIndex, int colIndex, int number) {
		//System.out.println(rowIndex + " "+colIndex+" - "+number);
		for(int i=0;i<BOARD_SIZE;i++) {
			if(sudokuTable[i][rowIndex] == number) {
				return false;
			}
		}
		
		for(int k=0;k<BOARD_SIZE;k++) {
			if(sudokuTable[colIndex][k] == number) {
				return false;
			}
		}
		
		int boxRowOffset = (colIndex/3)*BOX_SIZE;
		int boxColOffset = (rowIndex/3)*BOX_SIZE;
		
		for(int i=0;i<BOX_SIZE;i++) {
			for(int j=0;j<BOX_SIZE;j++) {
				if(number == sudokuTable[boxRowOffset+i][boxColOffset+j]) {
					return false;
				}
			}
		}
		
		return true;
	}

	private void printTable() {
		for(int i=0;i<BOARD_SIZE;i++) {
			if(i%3==0) System.out.println(" ");
			for(int j=0;j<BOARD_SIZE;j++) {
				if(j%3==0) {
					System.out.print(" ");
				}
				System.out.println(this.sudokuTable[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] sudokuTable = {
				{3,0,6,5,0,8,4,0,0},
				{5,2,0,0,0,0,0,0,0},
				{0,8,7,0,0,0,0,3,1},
				{0,0,3,0,1,0,0,8,0},
				{9,0,0,8,6,3,0,0,5},
				{0,5,0,0,9,0,6,0,0},
				{1,3,0,0,0,0,2,5,0},
				{0,0,0,0,0,0,0,7,4},
				{0,0,5,2,0,6,3,0,0},
		};

		SudokuProblem sudokuProblem = new SudokuProblem(sudokuTable);
		sudokuProblem.solveProblem();
	}

}
