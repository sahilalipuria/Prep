package redBlackTree;

public class Node {

	private int data;
	private NodeColor color;
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	
	public Node(int data) {
		super();
		this.data = data;
		this.color = NodeColor.RED;
	}
	
	@Override
	public String toString() {
		return ""+this.data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
