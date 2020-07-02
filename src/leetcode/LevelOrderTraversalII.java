/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 *
 */
public class LevelOrderTraversalII {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	List<Integer> currentLevel = new ArrayList<>();
        	
        	int currentSize = queue.size();
        	while(currentSize>0) {
        		TreeNode currentNode = queue.poll();
        		
        		if(currentNode.left!=null)
        			queue.add(currentNode.left);
        		
        		if(currentNode.right!=null)
        			queue.add(currentNode.right);
        		
        		currentLevel.add(currentNode.val);
        		currentSize--;
        	}
        	
        	result.add(currentLevel);
        }
        
        
        Collections.reverse(result);
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
