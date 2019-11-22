package trie;

public class Node {

	private String character;
	private Node[] childern;
	private boolean leaf;
	private boolean visited;
	private int value;
	
	public Node(String character) {
		super();
		this.character = character;
		this.childern = new Node[Constant.ALPHABET_SIZE];
	}
	
	public void setChild(int index,Node node,int value) {
		this.childern[index] = node;
		node.setValue(value);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Node[] getChildern() {
		return childern;
	}

	public void setChildern(Node[] childern) {
		this.childern = childern;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return this.character;
	}

	public Node getChild(int index) {
		return childern[index];
	}
}
