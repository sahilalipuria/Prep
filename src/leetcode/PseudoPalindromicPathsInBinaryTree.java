/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author salipuri
 * 
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * 
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

Example 1:



Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:



Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1
 

Constraints:

The given binary tree will have between 1 and 10^5 nodes.
Node values are digits from 1 to 9.
 *
 */

/**
 * Definition for a binary tree node. public */
 class TreeNode { 
	 int val; 
	 TreeNode left; 
	 TreeNode right; 
	 TreeNode() {} TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) { 
		 this.val = val; 
		 this.left = left; 
		 this.right = right; } }
 
public class PseudoPalindromicPathsInBinaryTree {

	/**
	 * @param args
	 */
	
	public static boolean isPalindromic(String path) {
		int[] charArray = new int[9];
        int localResult = 0;
        
        for(Character c: path.toCharArray()) {
    		if(charArray[Character.getNumericValue(c)-1]==0) {
    			charArray[Character.getNumericValue(c)-1]++;
    		}else
    			charArray[Character.getNumericValue(c)-1]--;
    	}
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!=0)
            	localResult++;
        }
        if(localResult>1)
        	return false;
        else
        	return true;
	}
	
	public static int pseudoPalindromicPaths (TreeNode root) {
        
		List<String> pathsList = new ArrayList<>();
        int result =0;
        
        getPaths(root,"",pathsList);
        
        for(String path: pathsList) {
        	if(isPalindromic(path))
        		result++;
        }
        
        return result;
    }
	
	private static void getPaths(TreeNode root, String string, List<String> pathsList) {
		
		if(root == null){
            return;
        }
        
        if(root.left==null && root.right==null){
            string += root.val;
            pathsList.add(string);
            return;
            
        }
	
        if(root.left!=null)
		    getPaths(root.left, string+root.val, pathsList);
        
		if(root.right!=null)
            getPaths(root.right, string+root.val, pathsList);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
