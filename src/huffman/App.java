package huffman;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "My name is Sahil";
		
		int[] charFrequencies = new int[256];
		
		for(char c:text.toCharArray()) {
			++charFrequencies[c];
		}
		
		HuffmanCode code = new HuffmanCode();
		HuffmanTree huffmanTree = code.buildTree(charFrequencies);
		code.printCodes(huffmanTree, new StringBuilder());

	}

}
