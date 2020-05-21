/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 */
public class KThSmallestInBST {

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
	
	public static int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inorder(root,k,nums);
        return nums[1];
        
    }
    
    public static void inorder(TreeNode root, int k,int[] nums){
        if(root==null)
            return;
        
        if(root.left!=null)
            inorder(root.left,k,nums);
        
        nums[0]++;
        if(nums[0]==k){
            nums[1] = root.val;
            return;
        }
        if(root.right!=null)
            inorder(root.right,k,nums);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
