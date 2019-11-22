/**
 * 
 */
package binarySearchTree;

/**
 * @author salipuri
 *
 */
public class TreeCompareHelper {

	/**
	 * @param args
	 */
	
	public boolean compareTrees(Node root1,Node root2) {
		
		if(root1==root2)
			return root1==root2;
		
		if(root1.getData().compareTo(root2.getData())!=0)
			return false;
		
		return compareTrees(root1.getLeftChild(), root2.getLeftChild())&&compareTrees(root1.getRightChild(), root2.getRightChild());
	}
	
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node x1 = new Node(2);
		Node y1 = new Node(3);
		root.left = x1;
		root.right = y1;
		root.left.left = new Node(4);
		root.right.left = new Node(6);
		Node x2 = new Node(7);
		Node y2 = new Node(9);
		root.right.left.left = new Node(8);
		root.right.left.right = y2;
		root.left.left.left = x2;

	}

}
