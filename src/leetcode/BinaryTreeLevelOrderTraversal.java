/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 */
public class BinaryTreeLevelOrderTraversal {

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
public static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int size = 0;
        while(!queue.isEmpty()){
            
            size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            while(size > 0){
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                
                if(current.left!=null){
                    queue.add(current.left);
                }
                
                if(current.right!=null){
                    queue.add(current.right);
                }    
                
                size--;
                
            }
            
            result.add(currentLevel); 
            
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		
		//System.out.println(levelOrder());

	}

}
