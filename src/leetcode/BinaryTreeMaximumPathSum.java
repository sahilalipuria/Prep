/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeMaximumPathSum {

	int result;
	
	public int dfs(TreeNode node) {
		int resultSum = 0;

		int leftHeight = (node.left != null) ? dfs(node.left) : 0;
		int rightHeight = (node.right != null) ? dfs(node.right) : 0;

		int nodeValue = node.val;

		if (leftHeight > rightHeight)
			nodeValue = Math.max(nodeValue, nodeValue + leftHeight);
		else
			nodeValue = Math.max(nodeValue, nodeValue + rightHeight);

		if (nodeValue > node.val + leftHeight + rightHeight) {
			result = Math.max(result, nodeValue);
		} else
			result = Math.max(result, node.val + leftHeight + rightHeight);

		return nodeValue;
	}
	
	public int maxPathSum(TreeNode root) {
        
		result = root.val;
		dfs(root);
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
