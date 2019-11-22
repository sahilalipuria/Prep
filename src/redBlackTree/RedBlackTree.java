package redBlackTree;

/**
 * @author salipuri
 * 
 *         Red black tree is a self balanced binary search tree invented by
 *         Rudolf Bayer in 1972. It is also called as 'symmetric binary B tree'.
 *         It has good worst case running time for its operations. It performs
 *         all the operations such as searching, insertion, deletion, in O(log n
 *         ) time where n is the number of nodes in the tree. In Red black tree,
 *         no data is stored at the leaves.
 * 
 *         Properties of Red Black Tree The color of a node is either black or
 *         red. The color of root node is always black. All leaf nodes are of
 *         black color. Every red node has both children of black color. Every
 *         path from a node to its leaf nodes contains equal number of black
 *         nodes. The longest path from the root node to any leaf node is no
 *         more than twice as long as the shortest path from the root to any
 *         other leaf in that tree.
 * 
 * 
 *         Lookup A red black tree is a BST. Lookup in an RBT is just lookup in
 *         a BST. The colors don't matter.
 * 
 *         Insertion The algorithm has three steps:
 * 
 *         Insert as you would into a BST, coloring the node red. If the parent
 *         of the node you just inserted was red, you have a double-red problem
 *         which you must correct. Color the root node black. A double red
 *         problem is corrected with zero or more recolorings followed by zero
 *         or one restructuring.
 * 
 *         Recoloring Recolor whenever the sibling of a red node's red parent is
 *         red:
 * 
 *         Restructuring Restructure whenever the red child's red parent's
 *         sibling is black or null. There are four cases:
 * 
 *         Right Left Right-Left Left-Right When you restructure, the root of
 *         the restructured subtree is colored black and its children are
 *         colored red.
 * 
 *         In AVL tree insertion, we used rotation as a tool to do balancing
 *         after insertion caused imbalance. In Red-Black tree, we use two tools
 *         to do balancing.
 * 
 *         1) Recoloring 2) Rotation
 * 
 * 
 * 
 *         We try recoloring first, if recoloring doesn’t work, then we go for
 *         rotation. Following is detailed algorithm. The algorithms has mainly
 *         two cases depending upon the color of uncle. If uncle is red, we do
 *         recoloring. If uncle is black, we do rotations and/or recoloring.
 * 
 *         Color of a NULL node is considered as BLACK.
 * 
 *         Let x be the newly inserted node. 1) Perform standard BST insertion
 *         and make the color of newly inserted nodes as RED.
 * 
 *         2) If x is root, change color of x as BLACK (Black height of complete
 *         tree increases by 1).
 * 
 *         3) Do following if color of x’s parent is not BLACK and x is not
 *         root. ….a) If x’s uncle is RED (Grand parent must have been black
 *         from property 4) ……..(i) Change color of parent and uncle as BLACK.
 *         ……..(ii) color of grand parent as RED. ……..(iii) Change x = x’s
 *         grandparent, repeat steps 2 and 3 for new x. redBlackCase2
 * 
 *         ….b) If x’s uncle is BLACK, then there can be four configurations for
 *         x, x’s parent (p) and x’s grandparent (g) (This is similar to AVL
 *         Tree) ……..i) Left Left Case (p is left child of g and x is left child
 *         of p) ……..ii) Left Right Case (p is left child of g and x is right
 *         child of p) ……..iii) Right Right Case (Mirror of case i) ……..iv)
 *         Right Left Case (Mirror of case ii)
 * 
 * 
 * 
 *         Deletion Steps Following are detailed steps for deletion.
 * 
 *         1) Perform standard BST delete. When we perform standard delete
 *         operation in BST, we always end up deleting a node which is either
 *         leaf or has only one child (For an internal node, we copy the
 *         successor and then recursively call delete for successor, successor
 *         is always a leaf node or a node with one child). So we only need to
 *         handle cases where a node is leaf or has one child. Let v be the node
 *         to be deleted and u be the child that replaces v (Note that u is NULL
 *         when v is a leaf and color of NULL is considered as Black).
 * 
 *         2) Simple Case: If either u or v is red, we mark the replaced child
 *         as black (No change in black height). Note that both u and v cannot
 *         be red as v is parent of u and two consecutive reds are not allowed
 *         in red-black tree. rbdelete11
 * 
 *         3) If Both u and v are Black.
 * 
 *         3.1) Color u as double black. Now our task reduces to convert this
 *         double black to single black. Note that If v is leaf, then u is NULL
 *         and color of NULL is considered as black. So the deletion of a black
 *         leaf also causes a double black.
 * 
 *         rbdelete12_new
 * 
 *         3.2) Do following while the current node u is double black and it is
 *         not root. Let sibling of node be s. ….(a): If sibling s is black and
 *         at least one of sibling’s children is red, perform rotation(s). Let
 *         the red child of s be r. This case can be divided in four subcases
 *         depending upon positions of s and r.
 * 
 * 
 * 
 *         …………..(i) Left Left Case (s is left child of its parent and r is left
 *         child of s or both children of s are red). This is mirror of right
 *         right case shown in below diagram.
 * 
 *         …………..(ii) Left Right Case (s is left child of its parent and r is
 *         right child). This is mirror of right left case shown in below
 *         diagram.
 * 
 *         …………..(iii) Right Right Case (s is right child of its parent and r is
 *         right child of s or both children of s are red) rbdelete13New
 * 
 *         …………..(iv) Right Left Case (s is right child of its parent and r is
 *         left child of s) rbdelete14
 * 
 *         …..(b): If sibling is black and its both children are black, perform
 *         recoloring, and recur for the parent if parent is black. rbdelete15
 *         In this case, if parent was red, then we didn’t need to recur for
 *         prent, we can simply make it black (red + double black = single
 *         black)
 * 
 *         …..(c): If sibling is red, perform a rotation to move old sibling up,
 *         recolor the old sibling and parent. The new sibling is always black
 *         (See the below diagram). This mainly converts the tree to black
 *         sibling case (by rotation) and leads to case (a) or (b). This case
 *         can be divided in two subcases. …………..(i) Left Case (s is left child
 *         of its parent). This is mirror of right right case shown in below
 *         diagram. We right rotate the parent p. …………..(iii) Right Case (s is
 *         right child of its parent). We left rotate the parent p. rbdelete16
 * 
 *         3.3) If u is root, make it single black and return (Black height of
 *         complete tree reduces by 1).
 */

public class RedBlackTree implements Tree {

	private Node root;

	@Override
	public void traverse() {

		if (root != null)
			inorderTraversal(root);

	}

	private void inorderTraversal(Node root) {

		if (root.getLeftChild() != null) {
			inorderTraversal(root.getLeftChild());
		}

		System.out.println(root + " - ");

		if (root.getRightChild() != null) {
			inorderTraversal(root.getRightChild());
		}

	}

	private void rightRotate(Node node) {
		System.out.println("Rotating to the right on Node: " + node);

		Node tempLeftNode = node.getLeftChild();
		node.setLeftChild(tempLeftNode.getRightChild());

		if (node.getLeftChild() != null) {
			node.getLeftChild().setParent(node);
		}

		tempLeftNode.setParent(node.getParent());

		if (tempLeftNode.getParent() == null)
			root = tempLeftNode;
		else if (node == node.getParent().getLeftChild())
			node.getParent().setLeftChild(tempLeftNode);
		else
			node.getParent().setRightChild(tempLeftNode);

		tempLeftNode.setRightChild(node);
		node.setParent(tempLeftNode);
	}

	private void leftRotate(Node node) {
		System.out.println("Rotating to the left on Node: " + node);

		Node tempRightNode = node.getRightChild();
		node.setRightChild(tempRightNode.getLeftChild());

		if (node.getRightChild() != null) {
			node.getRightChild().setParent(node);
		}

		tempRightNode.setParent(node.getParent());

		if (tempRightNode.getParent() == null)
			root = tempRightNode;
		else if (node == node.getParent().getLeftChild())
			node.getParent().setLeftChild(tempRightNode);
		else
			node.getParent().setRightChild(tempRightNode);

		tempRightNode.setLeftChild(node);
		node.setParent(tempRightNode);
	}

	@Override
	public void insert(int data) {

		Node node = new Node(data);

		root = insertIntoTree(root, node);

		fixViolations(node);

	}

	private void fixViolations(Node node) {

		Node parentNode = null;
		Node grandParentNode = null;

		// Until child's color is red and parent's color is red.
		while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {

			parentNode = node.getParent();
			grandParentNode = parentNode.getParent();

			if (parentNode == grandParentNode.getLeftChild()) { // parent is left child of grandparent
				Node uncle = grandParentNode.getRightChild(); // uncle is right child of grandparent

				if (uncle != null && uncle.getColor() == NodeColor.RED) { // If Uncle's color is RED(parent's color is
																			// RED)
					grandParentNode.setColor(NodeColor.RED); // Set grandparent as RED
					parentNode.setColor(NodeColor.BLACK); // Set parent as BLACK
					uncle.setColor(NodeColor.BLACK); // Set uncle as BLACK
					node = grandParentNode; // Set child as grandparent

				} else { // If Uncle's color is BLACK(parent's color is RED)
					if (node == parentNode.getRightChild()) { // PARENT IS LEFT CHILD AND CHILD IS RIGHT child so
																// ZIG-ZAG
						leftRotate(parentNode);
						node = parentNode; // Set previous parent as current node
						parentNode = node.getParent(); // And current node's parent as parent node
					}

					rightRotate(grandParentNode); // If Uncle's color is BLACK(parent's color is RED) and PARENT IS LEFT
													// CHILD AND CHILD IS left child so ZIG-ZIG
					NodeColor tempColor = parentNode.getColor(); // Get Parent node color
					parentNode.setColor(grandParentNode.getColor()); // Set parent node color as grandparent color as
																		// it's new grandparent
					grandParentNode.setColor(tempColor); // Grandparent will be the new child of parent so set its color
					node = parentNode; // Now child will be the parent node
				}
			} else { // parent is RIGHT child of grandparent

				Node uncle = grandParentNode.getLeftChild();

				if (uncle != null && uncle.getColor() == NodeColor.RED) { // If Uncle's color is RED(parent's color is
																			// RED)
					grandParentNode.setColor(NodeColor.RED); // Set grandparent as RED
					parentNode.setColor(NodeColor.BLACK); // Set parent as BLACK
					uncle.setColor(NodeColor.BLACK); // Set uncle as BLACK
					node = grandParentNode; // Set child as grandparent
				} else { // If Uncle's color is BLACK(parent's color is RED)
					if (node == parentNode.getLeftChild()) { // PARENT IS RIGHT CHILD AND CHILD IS LEFT child so ZIG-ZAG
						rightRotate(parentNode);
						node = parentNode; // Set previous parent as current node
						parentNode = node.getParent(); // And current node's parent as parent node
					}

					leftRotate(grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;
				}

			}
		}

		if (root.getColor() == NodeColor.RED) {
			root.setColor(NodeColor.BLACK);
		}

	}

	private Node insertIntoTree(Node root, Node node) {

		if (root == null)
			return node;

		if (node.getData() < root.getData()) {
			root.setLeftChild(insertIntoTree(root.getLeftChild(), node));
			root.getLeftChild().setParent(root);
		} else if (node.getData() > root.getData()) {
			root.setRightChild(insertIntoTree(root.getRightChild(), node));
			root.getRightChild().setParent(root);
		}

		return null;
	}

}
