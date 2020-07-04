`/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 *
 */
public class CousinsBinaryTree {

	/**
	 * @param args
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
	
	public static boolean isSameParent(TreeNode root,int child1,int child2){
        if(root == null)
            return false;
        
        if(root.left==null && root.right==null)
            return false;
        else if(root.left==null || root.right==null){
            if(root.left==null)
                return isSameParent(root.right,child1,child2);
            else
                return isSameParent(root.left,child1,child2);
        }
        
        return (root.left.val == child1 && root.right.val == child2) || (root.left.val == child2 && root.right.val == child1) || isSameParent(root.left,child1,child2) || isSameParent(root.right,child1,child2);
    }
	
	public static int getHeight(TreeNode root,int child,int height){
        
        if(root==null)
            return 0;
        
        if(root.val==child)
            return height;
        
        int level = getHeight(root.left,child,height+1);
        if(level!=0)
            return level;
        
        return getHeight(root.right,child,height+1);
    }
	
	public boolean isCousins(TreeNode root, int x, int y) {
        if(getHeight(root,x,1) != getHeight(root,y,1))
            return false;
        else{
            if(!isSameParent(root,x,y))
                return true;
            else
                return false;
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
