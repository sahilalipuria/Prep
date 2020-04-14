/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterBinaryTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public static int height(TreeNode root){
        if(root == null)
            return 0;
        
        return (1 + Math.max(height(root.left),height(root.right)));
    }
    
    public static int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        
        if(root == null)
            return diameter;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        diameter = leftHeight + rightHeight;
        
        
        return Math.max(diameter,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


