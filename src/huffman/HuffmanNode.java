package huffman;

/*
 * Left edge represents 0 and right edge represents 1
 * Parent node: sum of child nodes values
 */

public class HuffmanNode extends HuffmanTree{

	private HuffmanTree rightTree;
	private HuffmanTree leftTree;
	
	public HuffmanNode(HuffmanTree rightTree,HuffmanTree leftTree) {
		super(rightTree.getFrequency()+leftTree.getFrequency());
		this.rightTree = rightTree;
		this.leftTree = leftTree;
	}

	public HuffmanTree getRightTree() {
		return rightTree;
	}

	public void setRightTree(HuffmanTree rightTree) {
		this.rightTree = rightTree;
	}

	public HuffmanTree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(HuffmanTree leftTree) {
		this.leftTree = leftTree;
	}
	
}
