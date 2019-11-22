package huffman;

/*
 * The Huffman Coding Algorithm was discovered by David A. Huffman in the 1950s. The purpose of the Algorithm is lossless data compression.

This algorithm is commonly used in JPEG Compression.

Now traditionally to encode/decode a string, we can use ASCII values. But this doesn’t compress it. The number of bits involved in encoding the string isn’t reduced.

Unlike ASCII codes, Huffman codes use lesser number of bits.

The principle of Huffman code is based on the frequency of each data item.

Every data item is assigned a variable length of prefix code (typically a binary string).

The length of each prefix code is based on the frequency such that the most commonly occurring data has the smallest prefix code.

No two different data items would have the same prefix. Hence the prefixes are known as Prefix Codes. This is important to make sure decoded string is the same as the original string.

The more often the data is used the lesser bits it takes up.

The Huffman algorithm is a greedy algorithm. Since at every stage it looks for the best available option.
A Disadvantage of Huffman codes is that a minor change in any bit of the encoded string would break the whole message.
 */

import java.util.PriorityQueue;

public class HuffmanCode {
	
	public HuffmanTree buildTree(int[] charFrequencies) {
		
		PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();
		
		for(int i=0;i<charFrequencies.length;i++) {
			
			if(charFrequencies[i] > 0) {
				queue.add(new HuffmanLeaf(charFrequencies[i],(char) i));
			}
		}
		
		while(queue.size()>1) {
			
			HuffmanTree tree1 = queue.poll();
			HuffmanTree tree2 = queue.poll();
			
			queue.add(new HuffmanNode(tree1, tree2));
		}
		
		return queue.poll();
	}
	
	public void printCodes(HuffmanTree tree,StringBuilder prefix) {
		
		if(tree instanceof HuffmanLeaf) {
			
			HuffmanLeaf huffmanLeaf = (HuffmanLeaf) tree;
			System.out.println(huffmanLeaf.getValue()+"\t"+huffmanLeaf.getFrequency()+"\t"+prefix);
		}else {
			HuffmanNode node = (HuffmanNode) tree;
			
			prefix.append("0");
			printCodes(node.getLeftTree(), prefix);
			prefix.deleteCharAt(prefix.length()-1);
			
			prefix.append("1");
			printCodes(node.getRightTree(), prefix);
			prefix.deleteCharAt(prefix.length()-1);
			
		}
		
	}
	

}
