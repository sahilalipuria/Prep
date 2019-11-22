package lruCache;

/*
 * LRU cache stand for Least Recently Used Cache. which evict least recently used entry. 
As Cache purpose is to provide fast and efficient way of retrieving data. it need to meet certain requirement.
Some of the Requirement are
Fixed Size: Cache needs to have some bounds to limit memory usages.
Fast Access: Cache Insert and lookup operation should be fast , preferably O(1) time.
Replacement of Entry in case , Memory Limit is reached: A cache should have efficient algorithm to evict the entry when memory is full.
In case of LRU cache we evict least recently used entry so we have to keep track of recently used entries, entries which have not been used from long time and which have been used recently. plus lookup and insertion operation should be fast enough.
When we think about O(1) lookup , obvious data structure comes in our mind is HashMap. 
HashMap provide O(1) insertion and lookup. but HashMap does not has mechanism of tracking which entry has been queried recently and which not.

To track this we require another data-structure which provide fast insertion ,deletion and updation , in case of LRU we use Doubly Linkedlist . 
Reason for choosing doubly LinkList is O(1) deletion , updation and insertion if we have the address of Node on which this operation has to perform.
So our Implementation of LRU cache will have HashMap and Doubly LinkedList. 
In Which HashMap will hold the keys and address of the Nodes of Doubly LinkedList . And Doubly LinkedList will hold the values of keys.
As We need to keep track of Recently used entries, We will use a clever approach. 
We will remove element from bottom and add element on start of LinkedList and whenever any entry is accessed , it will be moved to top. 
so that recently used entries will be on Top and Least used will be on Bottom.
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int actualSize;
	private Map<Integer, Node> map;
	private DoublyLinkedList linkedList;
	
	public LRUCache() {
		this.map = new HashMap<>();
		this.linkedList = new DoublyLinkedList();
	}
	
	public void put(int id,String data) {
		
		//update the node if it already exists
		if(map.containsKey(id)) {
			Node node = this.map.get(id);
			node.setData(data);
			System.out.println("Inside put:"+node);
			//update the node to be the head(cache feature)
			update(node);
			return;
		}
		
		//the data is not present in the cache so insert it
		Node node = new Node(id, data);
		
		//We have to insert into the cache + set it to be the head node
		if(this.actualSize<Constants.CAPACITY) {
			this.actualSize++;
			add(node);
		}else {
			//or the cache is full:we have to remove the last item and insert the new one
			removeTail();
			add(node);
		}
	}

	//remove the last item // least frequenctly used
	private void removeTail() {
		
		//get node from map
		Node lastNode = this.map.get(this.linkedList.getTail().getId());
		
		//new tail node is the previous node(because we remove the actual one)
		this.linkedList.setTail(linkedList.getTail().getPreviousNode());
		
		//set the next node to be the null: because it is the right most item
		if(this.linkedList.getTail()!=null) {
			this.linkedList.getTail().setNextNode(null);
		}
		
		//avoid obsolete references
		lastNode = null;
		
	}

	//add node to the head
	private void add(Node node) {
		
		//the node will be the new head: so update accordingly
		node.setNextNode(this.linkedList.getHead());
		//it is first node: no previous node
		node.setPreviousNode(null);
		
		//we have to update the previous head:point to the new head(which is the node)
		if(linkedList.getHead()!=null) {
			linkedList.getHead().setPreviousNode(node);
		}
		
		linkedList.setHead(node);
		
		//if there is 1 node in the list,it will be head as well as tail
		if(linkedList.getTail()==null)
			linkedList.setTail(node);
		
		//we have to update the map with the node
		this.map.put(node.getId(), node);
		
	}
	
	public Node get(int id) {
		
		//the map doesn't contain the item [O(1) running time!!!!]
		if(!this.map.containsKey(id)) return null;
		
		//the map contains the item
		Node node = this.map.get(id);
		
		//Move to the head(frequently visited items must be close to the head)
		update(node);
		return node;
	}

	//move the given node to the front(head)
	private void update(Node node) {
		
		//doubly linked list: we can get the previous node and the next node
		Node previousNode = node.getPreviousNode();
		Node nextNode = node.getNextNode();
		
		if(previousNode!=null)
			previousNode.setNextNode(nextNode);
		else
			linkedList.setHead(nextNode);
		
		if(nextNode!=null)
			nextNode.setPreviousNode(previousNode);
		else
			this.linkedList.setTail(previousNode);
		
		add(node);
	}
	
	public void show() {
		
		Node actualNode = this.linkedList.getHead();
		
		//consider all the nodes in the linkedlist
		
		while(actualNode!=null) {
			System.out.print(actualNode+"<->");
			actualNode = actualNode.getNextNode();
		}
	}
	
}
