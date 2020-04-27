/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 *
 */
public class MaximalSquare {

	/**
	 * @param args
	 */
	
	public static int maximalSquare(char[][] matrix) {
        int result = 0;
        
        if(matrix.length == 0 || matrix[0].length == 0)
        	return result;
        
        int[][] dpTable = new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++) {
        	dpTable[i][0] = matrix[i][0] - '0';
        }
        
        for(int i=0;i<matrix[0].length;i++) {
        	dpTable[0][i] = matrix[0][i] - '0';
        }
        
        for(int i=1;i<matrix.length;i++) {
        	for(int j=1;j<matrix[0].length;j++) {
        		if(matrix[i][j] == '1')
        			dpTable[i][j] = Math.min(Math.min(dpTable[i-1][j], dpTable[i][j-1]),dpTable[i-1][j-1])+1;
        	}
        }
        
        
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[0].length;j++) {
        		result = Math.max(result, dpTable[i][j]*dpTable[i][j]);
        	}
        }	
        
        return result;	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
	}

}
