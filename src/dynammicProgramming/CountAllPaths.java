/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * Count All Paths from Top left to bottom right in Two Dimensional Array including Diagonal Paths
Objective: Count all the paths from left top corner to right bottom corner in two dimensional array.
Input: Two Dimensional array
Output: No of paths.
Approach :
1. Recursive
Recursive solution to this problem is similar to Print All Paths from Top left to bottom right in Two Dimensional Array
But the Time complexity will be exponential because there will be many sub problems which will be solved again and again to get the final solution. read this : “Dynamic programming vs Recursion

2. Dynamic Programming (Better Solution)
Create two dimensional resultCount array to store the number of paths from top left corner.
Base Case: To reach to any cell in either first row or column from first cell(top left at 0,0) will be 1.
You can reach to any cell from 3 different ways, from left, from top, from diagonal. So total no of paths to reach to that cell will be sum of all the paths to reach to left, top and diagonal cell.
 *
 */
public class CountAllPaths {

	/**
	 * @param args
	 */
	
	private int rowCount;
	private int colCount;
	private int[][] dpTable;
	private int[][] arr;
	
	
	
	public CountAllPaths(int[][] arr) {
		super();
		this.rowCount = arr.length;
		this.colCount = arr[0].length;
		this.arr = arr;
		this.dpTable = new int[rowCount][colCount];
	}
	
	public void solve() {
		for(int rowIndex =0;rowIndex<rowCount;rowIndex++) {
			dpTable[rowIndex][0] = 1;
		}
		
		for(int colIndex =1;colIndex<colCount;colIndex++) {
			dpTable[0][colIndex] = 1;
		}
		
		for(int rowIndex =1;rowIndex<rowCount;rowIndex++) {
			for(int colIndex =1;colIndex<colCount;colIndex++) {
				dpTable[rowIndex][colIndex] = dpTable[rowIndex-1][colIndex]+dpTable[rowIndex-1][colIndex-1]+ dpTable[rowIndex][colIndex-1];
			}
		}
		System.out.println("Total ways:"+dpTable[rowCount-1][colCount-1]);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 1, 2, 3 }, 
					  { 4, 5, 6 }, 
					  { 7, 8, 9 } };
		
		CountAllPaths countAllPaths = new CountAllPaths(a);
		countAllPaths.solve();

	}

}
