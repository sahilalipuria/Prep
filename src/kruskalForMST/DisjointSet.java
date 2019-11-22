/**
 * 
 */
package kruskalForMST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author salipuri
 * 
 * 	Also known as union-find data structure
 * 	Data structure to keep track of a set of elements partitioned into a number of disjoint(non-overlapping) subsets
 * 	Three main operations - find,union and makeSet
 * 	Disjoint sets can be implemented as linked lists but we prefer to implement as tree like structure
 * 	In Kruskal Algo it will be useful: with disjoint set we can decide in O(1) time approx whether two vertex are
 * 	in same set or not
 * 
 * 	We represent a set by a representative and we makeSet a set with it.
 * 	When we search for an item with find() then it returns the representative of the set
 * 	Union operation  is to merge two disjoint sets together by connecting them according to the representatives
 * 
 * 	PROBLEM: this tree like structure can become unbalanced.
 * 	OPTIONS: 
 * 		1.)Union by rank-> always attach smaller tree to the larger one then it will become more balanced thus faster.
 * 		2.)Path compression-> flattening the tree structure by setting every node to be connected to the root directly.
 * 
 * 	RANK: It is the depth of the tree.The rank of the set is equal to the rank of the representatives.
 * 
 * 	Union by rank-> we attach tree with smaller rank to tree with higher rank.
 * 
 * 	Applications:
 * 		- Mostly used in Kruskal algo
 * 		- To find adding a new edge to minimum spanning tree will introduce cycle or not
 * 		- for checking this-> union-find like data structure is extremely helpful
 * 		- we can check whether cycle is present or not->in asymptotically O(1) constant time
 *
 */
public class DisjointSet {
	
	private int nodeCount = 0 ;
	private int setCount = 0;
	private List<Node> rootNodes;			//representatives
	
	public DisjointSet(List<Vertex> vertexes) {
		super();
		this.rootNodes = new ArrayList<>(vertexes.size());
		makeSets(vertexes);
	}
	
	public void makeSets(List<Vertex> vertexes) {
		for(Vertex v:vertexes) {
			makeSet(v);
		}
	}
	
	public void makeSet(Vertex v) {
		Node n = new Node(rootNodes.size(), 0, null);
		v.setNode(n);
		this.rootNodes.add(n);
		this.setCount++;
		this.nodeCount++;
	}
	
	public int find(Node n) {
		
		Node currentNode = n;
		while(currentNode.getParent()!=null) {
			currentNode = currentNode.getParent();
		}
		
		Node rootNode = currentNode;
		currentNode = n;					//Start of path compression
		while(currentNode != rootNode) {
			Node temp = currentNode.getParent();
			currentNode.setParent(rootNode);
			currentNode = temp;
		}
		
		return rootNode.getId();
	}
	
	public void union(Node n1,Node n2) {
		
		int index1= find(n1);
		int index2= find(n2);
		
		if(n1==n2) {				//If they have same representative i.e. same parent
			return;
		}
		
		Node root1 = this.rootNodes.get(index1);
		Node root2 = this.rootNodes.get(index2);
		if(root1.getRank()<root2.getRank()) {			//Union by rank
			root1.setParent(root2);
		}
		else if(root1.getRank()>root2.getRank()) {
			root2.setParent(root1);
		}
		else {
			root2.setParent(root1);
			root1.setRank(root1.getRank()+1);
		}
		this.setCount--;
	}

}
