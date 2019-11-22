package kruskalForMST;

public class Node {
	
	private int id;
	private int rank;				//get height
	private Node parent;			//if parent itself then its the representative
	public Node(int id, int rank, Node parent) {
		this.id = id;
		this.rank = rank;
		this.parent = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
}
