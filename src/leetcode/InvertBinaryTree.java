/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 *
 *Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        TreeNode currentNode;
        
        while(!nodeQueue.isEmpty()){
            currentNode = nodeQueue.peek();
            nodeQueue.remove();
            
            
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp; 
            
            if(currentNode.left!= null)
                nodeQueue.add(currentNode.left);
            
            if(currentNode.right != null)
                nodeQueue.add(currentNode.right);
            
        }
        
        return root;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
