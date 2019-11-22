/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 *
 */
public class NQueensProblem {
	
	private static int numOfQueens;
	private static int[][] chessboard;
	
	public NQueensProblem(int numOfQueens) {
		numOfQueens = numOfQueens;
		chessboard = new int[numOfQueens][numOfQueens];
	}
	
	public static void solve() {
		if(setQueen(0))
			printQueens();
		else {
			System.out.println("NO SOLUTION......");
		}
	}

	public static void printQueens() {
		// TODO Auto-generated method stub
		for(int i=0;i<chessboard.length;i++) {
			for(int j=0;j<chessboard.length;j++) {
				if(chessboard[i][j]==1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
		
	}

	public static boolean setQueen(int colIndex) {
		
		if(colIndex==numOfQueens) {
			return true;
		}
		
		for(int rowIndex=0;rowIndex<numOfQueens;rowIndex++) {
			if(isPlaceValid(rowIndex,colIndex)) {
				chessboard[rowIndex][colIndex] =1;
				if(setQueen(colIndex+1))
					return true;
			}
			//BACKTRACKING
			chessboard[rowIndex][colIndex] =0;
		}
		
		return false;
	}

	public static boolean isPlaceValid(int rowIndex, int colIndex) {
		
		for(int i=0;i<colIndex;i++) {
			if(chessboard[rowIndex][i]==1) {
				return false;
			}
		}
		
		for(int i=rowIndex,j=colIndex;i>=0 && j>=0;i--,j--) {
			if(chessboard[i][j]==1) {
				return false;
			}
		}
		
		for(int i=rowIndex,j=colIndex;i<chessboard.length && j>=0;i++,j--) {
			if(chessboard[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensProblem nQueenProblem = new NQueensProblem(8);
		nQueenProblem.solve();

	}

}
