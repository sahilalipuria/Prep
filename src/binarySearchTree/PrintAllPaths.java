/**
 * 
 */
package binarySearchTree;

/**
 * @author salipuri
 *
 *Objective: Given a binary tree, Print paths from root to all leaf nodes

Input: A binary tree
 */
public class PrintAllPaths {

	/**
	 * @param args
	 */
	
	int [] paths = new int[500];
	int pathLength =0;
	
	public void printPaths(Node root,int[] path, int pathLen) {
		if(root == null)
			return;
		
		path[pathLen++] = root.data;
		
		if(root.left == null && root.right == null) {
			printLength(path,pathLen);
		}
		else {
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
	}
	
	private void printLength(int[] path, int pathLen) {
		for(int i=0;i<pathLen;i++) {
			System.out.print(path[i]+"-");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		root.left.left = new Node (4);
		root.left.left.left = new Node (7);
		root.right.left = new Node (6);
		root.right.left.left = new Node (8);
		root.right.left.right = new Node (9);
		int [] path = new int [100];
		PrintAllPaths p = new PrintAllPaths();
		p.printPaths(root, path, 0);

	}

}
