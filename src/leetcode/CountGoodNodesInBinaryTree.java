/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author salipuri
 * 
 * 1448. Count Good Nodes in Binary Tree
 * 
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.
 

Constraints:

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
 *
 */

/**
 * Definition for a binary tree node.*/ 


public class CountGoodNodesInBinaryTree {

	/**
	 * @param args
	 */
	
	static class TreeNode { 
		 int val; 
		 TreeNode left; 
		 TreeNode right; 
		 TreeNode() {} TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) { 
			 this.val = val; 
			 this.left = left; 
			 this.right = right; 
		 } 
	}
	
	private int goodNodes;
	
	public CountGoodNodesInBinaryTree() {
		this.goodNodes = 0;
	}
	
	public int goodNodes(TreeNode root) {
        
		buildPaths(root,root.val);
        
        if(root!=null)
		    return this.goodNodes+1;
        else
            return this.goodNodes;
    }
	
	public void buildPaths(TreeNode root,Integer max) {
		
		if(root==null)
			return;
	
		if(root.left!=null){
            if(root.left.val>=max){
                goodNodes++;
            } 
            buildPaths(root.left,Math.max(max,root.left.val)); 
        }
		
		if(root.right!=null){
            if(root.right.val>=max){
                goodNodes++;
            }
            buildPaths(root.right,Math.max(max,root.right.val));   
        }
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
