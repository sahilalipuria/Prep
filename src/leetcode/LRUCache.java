/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

import lruCache.DoublyLinkedList;
import lruCache.Node;

/**
 * @author salipuri
 * 
 *         Design and implement a data structure for Least Recently Used (LRU)
 *         cache. It should support the following operations: get and put.
 * 
 *         get(key) - Get the value (will always be positive) of the key if the
 *         key exists in the cache, otherwise return -1. put(key, value) - Set
 *         or insert the value if the key is not already present. When the cache
 *         reached its capacity, it should invalidate the least recently used
 *         item before inserting a new item.
 * 
 *         The cache is initialized with a positive capacity.
 * 
 *         Follow up: Could you do both operations in O(1) time complexity?
 * 
 *         Example:
 * 
 *         LRUCache cache = new LRUCache( 2 /* capacity);
 * 
 *         cache.put(1, 1); cache.put(2, 2); cache.get(1); // returns 1
 *         cache.put(3, 3); // evicts key 2 cache.get(2); // returns -1 (not
 *         found) cache.put(4, 4); // evicts key 1 cache.get(1); // returns -1
 *         (not found) cache.get(3); // returns 3 cache.get(4); // returns 4
 *
 */

class CacheNode {
	int key, value;
	// pointer to the previous node and next node
	CacheNode left;
	CacheNode right;

	CacheNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class DoublyLinkedList {
	int size = 0;
	CacheNode start = null;
	CacheNode end = null;

	void remove(CacheNode node) {
		// the node is at the start
		if (node.left == null) {
			start = node.right;
		} else {
			// attach the previous node to the netx node
			node.left.right = node.right;
		}
		// the node is at the end
		if (node.right == null) {
			end = node.left;
		} else {
			// attach the next node to the previous node
			node.right.left = node.left;
		}
	}

	void addAtTop(CacheNode node) {

		// replace start with new node
		node.left = null;
		// if start is null
		if (start != null) {
			node.right = start;
			start.left = node;
		}
		start = node;
		// only node in the list
		if (end == null)
			end = start;
	}
}

public class LRUCache {

	HashMap<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
	int capacity;
	int currentCapacity = 0;
	CacheNode start = null;
	CacheNode end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			CacheNode node = map.get(key);
			remove(node);
			addAtTop(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		CacheNode node;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			remove(node);
		} else {
			node = new CacheNode(key, value);
			map.put(key, node);
			if (map.size() > capacity) // We have reached maxium size so need to make room for new element.
			{
				map.remove(end.key);
				remove(end);
			}
		}

		addAtTop(node);
	}

	void remove(CacheNode node) {
		// the node is at the start
		if (node.left == null) {
			start = node.right;
		} else {
			// attach the previous node to the netx node
			node.left.right = node.right;
		}
		// the node is at the end
		if (node.right == null) {
			end = node.left;
		} else {
			// attach the next node to the previous node
			node.right.left = node.left;
		}
	}

	void addAtTop(CacheNode node) {

		// replace start with new node
		node.left = null;
		// if start is null
		if (start != null) {
			node.right = start;
			start.left = node;
		}
		start = node;
		// only node in the list
		if (end == null)
			end = start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
		 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
		 */

		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4

	}

}
