package linkedList;

public class LinkedList <T extends Comparable<T>> implements List<T>{
	
	private Node<T> head;
	private int sizeCounter;
	
	public Node<T> getMiddNode(){
		
		Node<T> fastPointer= this.head;
		Node<T> slowPointer= this.head;
		
		while(fastPointer.getNextNode()!=null && fastPointer.getNextNode().getNextNode()!=null) {
			fastPointer= fastPointer.getNextNode().getNextNode();
			slowPointer = slowPointer.getNextNode();
		}
		
		return slowPointer;
	}
	
	public void reverseList() {
		
		Node<T> currentNode = this.head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;
		
		while(currentNode!=null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode =nextNode;
		}
		
		this.head = prevNode;
	}

}
