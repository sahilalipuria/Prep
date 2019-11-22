package avlTree;

public class App {

	public static void main(String[] args) {
		
		Node root = null;
		AVLTree i = new AVLTree();
		root = i.insert(root, 4);
		root = i.insert(root, 2);
		root = i.insert(root, 1);
		root = i.insert(root, 5);
		root = i.insert(root, 6);
		root = i.insert(root, 9);
		root = i.insert(root, 14);
		root = i.insert(root, 11);
		root = i.insert(root, 10);
		root = i.insert(root, 20);
		System.out.print("Inorder Traversal of Constructed AVL Tree :");
		i.inorder(root);
		System.out.print("\n New Root of AVL Tree is : " + root.data);

	}

}
