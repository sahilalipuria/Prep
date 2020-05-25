/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Uncrossed Lines
 * 
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
 

Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000
 *
 */
public class UncrossedLines {

	/**
	 * @param args
	 */
	
	public static int maxUncrossedLines(int[] A, int[] B) {
		
		int result = 0;
        
		int dpTable[][] = new int[A.length+1][B.length+1];
		
		for(int i=0;i<=A.length;i++)
			dpTable[i][0] = 0;
		
		for(int i=0;i<=B.length;i++)
			dpTable[0][i] = 0;
		
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				
				if(A[i-1]==B[j-1]) {
					dpTable[i][j]=dpTable[i-1][j-1]+1;
				}else
					dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i][j-1]);
			}
		}
        
        return dpTable[A.length][B.length];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(maxUncrossedLines(new int[] {1,4,2}, new int[] {1,2,4}));
		System.out.println(maxUncrossedLines(new int[] {2,5,1,2,5}, new int[] {10,5,2,1,5,2}));
		System.out.println(maxUncrossedLines(new int[] {1,3,7,1,7,5}, new int[] {1,9,2,5,1}));
		System.out.println(maxUncrossedLines(new int[] {1,1,2,1,2}, new int[] {1,3,2,3,1}));
	}

}
