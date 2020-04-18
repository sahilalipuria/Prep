/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 *
 */
public class NumOfIslands {

	/**
	 * @param args
	 */
	
	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int count = 0;
        
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count+= dfs(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public static int dfs(char[][] grid, int i, int j){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0';
            
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        
        return 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}

}
