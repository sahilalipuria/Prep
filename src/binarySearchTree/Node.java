package binarySearchTree;

public class Node{

	Node left;
	int data;
    Node right;
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
