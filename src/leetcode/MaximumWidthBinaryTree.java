/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * 662. Maximum Width of Binary Tree
 * 
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.


 *
 */
public class MaximumWidthBinaryTree {

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
	
	public static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        
        if(root==null)
            return maxWidth;
        
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        
        queue.offer(root);
        map.put(root,0);
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            int start = map.get(queue.peek());
            int currentIndex = start;
            
            while(currentSize!=0){
                TreeNode currentNode = queue.poll();
                currentIndex = map.get(currentNode);
                
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                    map.put(currentNode.left,2*currentIndex);
                }
                
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                    map.put(currentNode.right,2*currentIndex+1);
                }
                currentSize--;
            }
            
            maxWidth = Math.max(maxWidth,currentIndex - start +1);
        }
        
        return maxWidth;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(widthOfBinaryTree(new int[] {1,3,2,5,3,null,9}));
	}

}
