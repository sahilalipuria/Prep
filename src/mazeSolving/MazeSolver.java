package mazeSolving;

import javax.management.RuntimeErrorException;

public class MazeSolver {

	private int[][] mazeMap;
	private boolean[][] visited;
	private int startPositionRow;
	private int startPositionCol;
	public MazeSolver(int[][] mazeMap, int startPositionRow, int startPositionCol) {
		this.mazeMap = mazeMap;
		this.visited = new boolean[mazeMap.length][mazeMap.length];
		this.startPositionRow = startPositionRow;
		this.startPositionCol = startPositionCol;
	}
	
	public void findWayOut() {
		try {
			dfs(startPositionRow,startPositionCol);
		}catch(RuntimeException e) {
			System.out.println("Route found to exit");
		}
	}
	
	public void dfs(int rowIndex,int colIndex) {
		System.out.println("Visiting Row: "+ rowIndex+",Column: "+colIndex);
		if(this.mazeMap[rowIndex][colIndex]==3) {
			throw new RuntimeErrorException(null);
		}
		int endOfMap = mazeMap.length -1;
		if(visited[rowIndex][colIndex]) {
			return;
		}
		else if(rowIndex < 0 || rowIndex>endOfMap) {
			return;
		}
		else if(colIndex < 0 || colIndex>endOfMap) {
			return;
		}
		else if(mazeMap[rowIndex][colIndex]==1) {
			return;
		}
		else {
			System.out.println("Actual Move Row: "+ rowIndex+",Column: "+colIndex);
			this.visited[rowIndex][colIndex]=true;
			dfs(rowIndex+1,colIndex);		//Going down
			dfs(rowIndex,colIndex+1);		//Going right
			dfs(rowIndex,colIndex-1);		//Going left
			dfs(rowIndex-1,colIndex);		//Going up
		}
	}
}
