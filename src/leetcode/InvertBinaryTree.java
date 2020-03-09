/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 *
 */
public class InvertBinaryTree {

	/**
	 * @param args
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
