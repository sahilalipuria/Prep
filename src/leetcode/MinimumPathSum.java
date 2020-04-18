/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {

	/**
	 * @param args
	 */
	
	public int minPathSum(int[][] grid) {
        int[][] dpTable = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(i == 0 && j==0)
                    dpTable[0][0] = grid[0][0];
                else if(i==0)
                    dpTable[i][j] = grid[i][j] + dpTable[i][j-1];
                else if(j==0)
                    dpTable[i][j] = grid[i][j] + dpTable[i-1][j];
                else
                    dpTable[i][j] = grid[i][j] + Math.min(dpTable[i][j-1],dpTable[i-1][j]);
                
            }
        }
        
        return dpTable[grid.length-1][grid[0].length-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
