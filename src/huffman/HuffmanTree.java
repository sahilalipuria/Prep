package huffman;

/*
 * The basic idea of the Huffman Algorithm is building a Tree from bottom up.

The steps involved in building the Huffman Tree are:

Get Frequency of each character and store it in a Map.
Create a node for each character with its frequency and insert it into a Min Priority Queue.
Extract the two nodes with the minimum frequency from the priority queue.
Create a new node by merging these two nodes as children and with weight equal to the sum of the two nodes frequencies.
Add this back to the Priority Queue.
Repeat till the Priority Queue has only one node left. That node becomes the root of the Huffman Tree.
Once the tree is built, to find the prefix code of each character we traverse the tree as:

Starting at the top when you go left, append 0 to the prefix code string.
When you go right, append 1.
Stop when you have reached the Leaf nodes.
The string of 0 and 1s created till now is the prefix code of that particular Node in the tree.
During decoding, we just need to print the character of each leaf traversed by the above prefix code in the Huffman tree.

All Input characters are present only in the leaves of the Huffman tree.
 */

public class HuffmanTree implements Comparable<HuffmanTree>{
	
	protected int frequency;

	public HuffmanTree(int frequency) {
		this.frequency = frequency;
	}
	
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int compareTo(HuffmanTree otherTree) {
		return Integer.compare(this.frequency, otherTree.getFrequency()); 
	}
	
	

}
