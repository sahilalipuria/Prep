/**
 * 
 */
package binarySearchTree;

/**
 * @author salipuri
 * 
 * Objective: Given a binary tree and two nodes, Check if they are cousins

Input: A binary tree and two nodes

Cousin Nodes: Cousin nodes are the nodes who are at the same level in the tree and whose parents are siblings.
 *
 */
public class CheckIfTwoNodesAreCousins {

	/**
	 * @param args
	 */
	
	private boolean areCousins(Node root, Node x1, Node y1) {
		// TODO Auto-generated method stub
		
		if(getHeight(root,x1,1) != getHeight(root,y1,1)) {
			return false;
		}
		else {
			if(!sameParents(root,x1,y1))
				return false;
			else
				return true;
		}
	}
	
	private boolean sameParents(Node root, Node x1, Node y1) {
		if(root==null) {
			return false;
		}
		return ((root.left==x1 && root.right==y1) || (root.left == y1 && root.right == x1) || sameParents(root.left, x1, y1) || sameParents(root.right, x1, y1));
	}

	private int getHeight(Node root, Node x1, int height) {
		
		if(root==null) {
			return 0;
		}
		else if(root == x1) {
			return height;
		}
		
		int level = getHeight(root.left, x1, height+1);
		if(level!=0)
			return level;
		
		return getHeight(root.right, x1, height+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		CheckIfTwoNodesAreCousins i = new CheckIfTwoNodesAreCousins();
		System.out.println("Node " + x1.data + " and Node " + y1.data + " are cousins??? " + i.areCousins(root, x1, y1));
		System.out.println("Node " + x2.data + " and Node " + y2.data + " are cousins??? " + i.areCousins(root, x2, y2));
	}

}
