/**
 * 
 */
package avlTree;

/**
 * @author salipuri
 * 
 * AVL tree is widely known as self-balancing binary search tree. It is named after its creator (Georgy Adelson-Velsky and Landis’ tree). In AVL Tree, the heights of child subtrees at any node differ by at most 1. At anytime if height difference becomes greater than 1 then tree balancing is done to restore its property.

Search, Insertion and deletion, all operations takes O(logn) time since the tree is balanced.

Why AVL Tree is better than normal Binary Search Tree:

Average time complexity in binary search tree for any operation takes O(logn) time but there are times when your tree is skewed. 
In those cases the operations on them takes O(n) time but in AVL Tree, since it is always balanced, it always takes O(logn) time.

How Tree balanced itself:

There are two basic operations, using which tree balanced itself.

Left Rotation
Right Rotation.
AVL Rotations

How These Rotation works to balance the tree:

Let ‘A’ be the new node added to the tree.
Once ‘A’ is added, start travelling up from ‘A’ to root and find the unbalanced node, balance it and again keep traveling up.
Say you have found the node z which is unbalanced.
Node y is the child of z and x be the grandchild of z.
Then there will be four possibilities

Left-Left Case : – x is the left child of y and y is the left child of z.
Left-Right Case : – x is the right child of y and y is the left child of z.
Right-Left Case : – x is the left child of y and y is the right child of z.
Right-Right Case : – x is the right child of y and y is the right child of z.
 

Left-Left Case : – x is the left child of y and y is the left child of z.

Left-Left Case

Left-Right Case : – x is the right child of y and y is the left child of z.

Right-Left Case : – x is the left child of y and y is the right child of z.

Right-Right Case : – x is the right child of y and y is the right child of z.

Right-RightInsertion Operation:

Insert the new Node using recursion so while back tracking you will all the parents nodes to check whether they are still balanced or not.
Every node has a field called height with default value as 1.
When new node is added, its parent’s node height get increased by 1.
So as mentioned in step 1, every ancestors height will get updated while back tracking to the root.
At every node the balance factor will also be checked. balance factor = (height of left Subtree – height of right Subtree).
If balance factor =1 means tree is balanced at that node.
If balance factor >1 means tree is not balanced at that node, left height is more that the right height so that means we need rotation. (Either Left-Left Case or Left-Right Case).
Say the current node which we are checking is X and If new node is less than the X.left then it will be Left-Left case, and if new node is greater than the X.left then it will be Left-Right case. see the pictures above.
If balance factor <-1 means tree is not balanced at that node, right height is more that the left height so that means we need rotation. (Either Right-Right Case or Right- Left Case)
Say the current node which we are checking is X and If new node is less than the X.right then it will be Right-Right case, and if new node is greater than the X.right then it will be Right-Left case. see the pictures above.
 *
 */
public class AVLTree {
	
	public int getBalance(Node n) {
		if (n != null) {
			return (getHeight(n.left) - getHeight(n.right));
		}
		return 0;
	}

	public int getHeight(Node n) {
		if (n != null) {
			return n.height;
		}
		return 0;
	}

	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Rotation
		x.right = y;
		y.left = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return x;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Rotation
		y.left = x;
		x.right = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return (new Node(data));
		}
		if (node.data > data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// update the node height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		int balDiff = getBalance(node);

		// Right Rotate
		if (balDiff > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		// Left Rotate
		if (balDiff < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// Left Right Rotate
		if (balDiff > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Rotate
		if (balDiff < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}

}
