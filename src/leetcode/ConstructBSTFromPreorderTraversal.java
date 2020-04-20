/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
 *
 */
public class ConstructBSTFromPreorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/**
	 * @param args
	 * 
	 *
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public static TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder == null || preorder.length ==0)
        	return null;
        
        TreeNode root = bstFromPreorder(preorder, 0, preorder.length-1);
        
        return root;
    }
	
	
	public static TreeNode bstFromPreorder(int[] preorder,int beginIndex, int endindex) {
		
		if (preorder == null || preorder.length == 0 || endindex < beginIndex)
			return null;

		int i;

		for (i = beginIndex + 1; i <= endindex; i++) {
			if (preorder[i] > preorder[beginIndex]) {
				break;
			}
		}
        
		TreeNode root = new TreeNode(preorder[beginIndex]);
		root.left = bstFromPreorder(preorder, beginIndex+1, i-1);
		root.right = bstFromPreorder(preorder, i, endindex);
        
        return root;
    }
	
	public static void inorder(TreeNode root) {
		
		if(root == null)
			return;
		
		System.out.print(root.val+" ");
		inorder(root.left);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = bstFromPreorder(new int[] {8,5,1,7,10,12});
		inorder(root);
		System.out.println();
		root = bstFromPreorder(new int[] {4,2});
		inorder(root);
		

	}

}
