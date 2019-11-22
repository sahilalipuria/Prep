/**
 * 
 */
package binarySearchTree;

/**
 * @author salipuri
 *
 */
public class GetKSmallestElement {

	/**
	 * @param args
	 */
	
	private int treeSize(Node root) {
		
		if(root==null)
			return 0;
		
		return (treeSize(root.getLeftChild())+treeSize(root.getRightChild())+1);
	}
	
	private Node getKSmallest(Node root,int k) {
		
		int n = treeSize(root);
		
		if(n==k)
			return root;
		
		if(n>k)
			return getKSmallest(root.getLeftChild(), k);
		
		if(n<k)
			return getKSmallest(root.getRightChild(), n-k);
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
