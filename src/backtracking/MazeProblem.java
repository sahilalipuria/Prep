/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 *
 *Important problem in robotics. There may be several obstacles.For eg: vaccum cleaner
 *So again -> there are constraints/obstacles
 *It is sort of DFS
 *
 */
public class MazeProblem {

	/**
	 * @param args
	 */
	
	private static int[][] mazeMatrix;
	private static int[][] solutionMatrix;
	private static int mazeSize;
	
	public MazeProblem(int[][] mazeTable) {
		this.mazeMatrix = mazeTable;
		this.mazeSize = mazeTable.length;
		this.solutionMatrix = new int[mazeSize][mazeSize];
	}
	
	public void showResults() {
		for(int i=0;i<mazeSize;i++) {
			for(int j=0;j<mazeSize;j++) {
				System.out.print(" "+solutionMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void solve() {
		if(solveMaze(0,0)) {
			showResults();
		}
		else {
			System.out.println("NO RESULTS");
		}
	}
	
	public boolean solveMaze(int x,int y) {
		if(isFinished(x,y)) {
			return true;
		}
		if(isValid(x,y)) {
			solutionMatrix[x][y] = 1;
			
			if(solveMaze(x+1, y)) {
				return true;
			}
			if(solveMaze(x, y+1)) {
				return true;
			}
			//BACKTRACK
			solutionMatrix[x][y] = 0;
		}
		return false;
	}
	
	private boolean isValid(int x, int y) {
		
		if(x<0 || x >= mazeSize ) return false;
		
		if(y<0 || y >= mazeSize ) return false;
		
		if(mazeMatrix[x][y] != 1) return false;
		
		return true;
	}

	public boolean isFinished(int x, int y) {
		
		if(x==mazeSize-1 && y==mazeSize-1) {
			solutionMatrix[x][y] = 1;
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mazeTable [][] = {
				{1,1,1,1,1},
				{1,0,0,1,0},
				{0,0,0,1,0},
				{1,1,1,1,1},
				{1,1,1,0,1}
				
		};
		
		MazeProblem mazeProblem = new MazeProblem(mazeTable);
		mazeProblem.solve();

	}

}
