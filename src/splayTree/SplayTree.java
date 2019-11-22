package splayTree;

import linkedList.RotateLinkedList;

/*
 * The worst case time complexity of Binary Search Tree (BST) operations like search, delete, insert is O(n). 
 * The worst case occurs when the tree is skewed. We can get the worst case time complexity as O(Logn) with AVL and Red-Black Trees.

Can we do better than AVL or Red-Black trees in practical situations?
Like AVL and Red-Black Trees, Splay tree is also self-balancing BST. 
The main idea of splay tree is to bring the recently accessed item to root of the tree, this makes the recently searched item to be accessible in O(1) time if accessed again. 
The idea is to use locality of reference (In a typical application, 80% of the access are to 20% of the items). 
Imagine a situation where we have millions or billions of keys and only few of them are accessed frequently, which is very likely in many practical applications.

All splay tree operations run in O(log n) time on average, where n is the number of entries in the tree. Any single operation can take Theta(n) time in the worst case.
 */

public class SplayTree<T extends Comparable<T>> implements Tree<T>{

	private int size;
	private Node<T> rootNode;
	
	@Override
	public void insert(T data) {
		
		Node<T> tempNode = this.rootNode;
		Node<T> parentNode = null;
		
		while(tempNode != null) {
			
			parentNode = tempNode;
			
			if(tempNode.getData().compareTo(data)<0)
				tempNode = tempNode.getRightNode();	
			else
				tempNode = tempNode.getLeftNode();
		}
		
		tempNode = new Node<T>(data);
		tempNode.setParentNode(parentNode);
		
		if(parentNode==null) 
			this.rootNode = tempNode;
		else if(parentNode.getData().compareTo(tempNode.getData())<0)
			parentNode.setRightNode(tempNode);
		else
			parentNode.setLeftNode(tempNode);
		
		splay(tempNode);
		this.size++;
		
	}

	private void splay(Node<T> node) {
		
		while(node.getParentNode()!=null) {
			
			//ZIG SITUATION
			if(node.getParentNode().getParentNode()==null) {
				if(node.getParentNode().getLeftNode()==node) //the node is a left child + grandparent is null
					rotateRight(node.getParentNode());
				else										//the node is a right child + grandparent is null
					rotateLeft(node.getParentNode());
			
			//ZIG-ZIG SITUATION
			} else if(node.getParentNode().getLeftNode() == node	// so left child and parent is left child too
					&& node.getParentNode().getParentNode().getLeftNode() ==  node.getParentNode()) {
				rotateRight(node.getParentNode().getParentNode());
				rotateRight(node.getParentNode());
			}else if(node.getParentNode().getRightNode() == node	// so right child and parent is right child too
					&& node.getParentNode().getParentNode().getRightNode() ==  node.getParentNode()) {
				rotateLeft(node.getParentNode().getParentNode());
				rotateLeft(node.getParentNode());
				
			//ZIG-ZAG SITUATION	
			}else if(node.getParentNode().getLeftNode() == node	// zig-zag: so left child and parent is right child 
					&& node.getParentNode().getParentNode().getRightNode() ==  node.getParentNode()) {
				rotateRight(node.getParentNode());
				rotateLeft(node.getParentNode());
				
			}else { 				//zig-zag: so right child and parent is left child 
				rotateLeft(node.getParentNode());
				rotateRight(node.getParentNode());
			}
		}
		
	}

	private void rotateLeft(Node<T> node) {
		
		Node<T> tempNode = node.getRightNode();
		
		if(tempNode !=null) {
			node.setRightNode(tempNode.getLeftNode());
			
			if(tempNode.getLeftNode()!=null) {
				tempNode.getLeftNode().setParentNode(node);
			}
			
			tempNode.setParentNode(node.getParentNode());
		}
		
		if(node.getParentNode()==null) {
			this.rootNode = tempNode;
		}else if(node == node.getParentNode().getLeftNode()) {
			node.getParentNode().setLeftNode(tempNode);
		}else {
			node.getParentNode().setRightNode(tempNode);
		}
		
		if(tempNode!=null) {
			tempNode.setLeftNode(node);
		}
		
		node.setParentNode(tempNode);
	}
	
	private void rotateRight(Node<T> node) {
		
		Node<T> tempNode = node.getLeftNode();
		
		if(tempNode !=null) {
			node.setLeftNode(tempNode.getRightNode());
			
			if(tempNode.getRightNode()!=null) {
				tempNode.getRightNode().setParentNode(node);
			}
			
			tempNode.setParentNode(node.getParentNode());
		}
		
		if(node.getParentNode()==null) {
			this.rootNode = tempNode;
		}else if(node == node.getParentNode().getLeftNode()) {
			node.getParentNode().setLeftNode(tempNode);
		}else {
			node.getParentNode().setRightNode(tempNode);
		}
		
		if(tempNode!=null) {
			tempNode.setRightNode(node);
		}
		
		node.setParentNode(tempNode);
	}

	@Override
	public Node<T> find(T data) {
		
		Node<T> tempNode = this.rootNode;
		
		while(tempNode!=null) {
			if(tempNode.getData().compareTo(data)<0)
				tempNode = tempNode.getRightNode();
			else if(tempNode.getData().compareTo(data)>0)
				tempNode = tempNode.getLeftNode();
			else {
				splay(tempNode);
				return tempNode;
			}
		}
		
		splay(tempNode);
		
		return null;
	}

	@Override
	public T getMin() {
		
		if(this.rootNode!=null) {
			return getMin(this.rootNode);
		}
		
		return null;
	}

	private T getMin(Node<T> node) {
		
		if(!isEmpty()) {
			return getMin(node.getLeftNode());
		}else {
			return node.getData();
		}
	}

	@Override
	public T getMax() {
		if(this.rootNode!=null) {
			return getMax(this.rootNode);
		}
		
		return null;
	}

	private T getMax(Node<T> node) {
		if(!isEmpty()) {
			return getMin(node.getRightNode());
		}else {
			return node.getData();
		}
	}

	@Override
	public void inOrderTraversal() {
		if(this.rootNode!=null)
			inOrderTraversal(this.rootNode);
		
	}

	private void inOrderTraversal(Node<T> node) {
		
		if(node.getLeftNode()!=null) {
			inOrderTraversal(node.getLeftNode());
		}
		
		System.out.println(node +" ");
		
		if(node.getRightNode()!=null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	public void printRoot() {
		System.out.println(this.rootNode);
	}
	
	public boolean isEmpty() {
		return this.rootNode == null;
	}
	
	public int size() {
		return this.size;
	}
}
