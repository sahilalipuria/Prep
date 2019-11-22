/**
 * 
 */
package ternaryStructureTree;

/**
 * @author salipuri
 * 
 * A ternary search tree is a special trie data structure where the child nodes of a standard trie are ordered as a binary search tree.
Representation of ternary search trees:
Unlike trie(standard) data structure where each node contains 26 pointers for its children, each node in a ternary search tree contains only 3 pointers:
1. The left pointer points to the node whose value is less than the value in the current node.
2. The equal pointer points to the node whose value is equal to the value in the current node.
3. The right pointer points to the node whose value is greater than the value in the current node.

Apart from above three pointers, each node has a field to indicate data(character in case of dictionary) and another field to mark end of a string.
So, more or less it is similar to BST which stores data based on some order. However, data in a ternary search tree is distributed over the nodes. e.g. It needs 4 nodes to store the word “Geek”.
Below figure shows how exactly the words in a ternary search tree are stored?




One of the advantage of using ternary search trees over tries is that ternary search trees are a more space efficient (involve only three pointers per node as compared to 26 in standard tries). 
Further, ternary search trees can be used any time a hashtable would be used to store strings.

Tries are suitable when there is a proper distribution of words over the alphabets so that spaces are utilized most efficiently. 
Otherwise ternary search trees are better. Ternary search trees are efficient to use(in terms of space) when the strings to be stored share a common prefix.

Applications of ternary search trees:
1. Ternary search trees are efficient for queries like “Given a word, find the next word in dictionary(near-neighbor lookups)” or 
“Find all telephone numbers starting with 9342 or “typing few starting characters in a web browser displays all website names with this prefix”(Auto complete feature)”.

2. Used in spell checks: Ternary search trees can be used as a dictionary to store all the words. 
Once the word is typed in an editor, the word can be parallelly searched in the ternary search tree to check for correct spelling.
 *
 */
public class TST {

	private Node rootNode;
	
	public void put(String key,int value) {
		
		rootNode = put(rootNode,key,value,0);
	}

	public Node put(Node node, String key, int value, int index) {
		
		char c = key.charAt(index);
		if(node == null) {
			node = new Node(c);
		}
		
		if(c<node.getCharacter()) {
			node.setLeftNode(put(node.getLeftNode(), key, value, index));
		}else if(c>node.getCharacter()) {
			node.setRightNode(put(node.getRightNode(), key, value, index));
		}else if(index < key.length() -1) {
			node.setMiddleNode(put(node.getMiddleNode(), key, value, index+1));
		}else {
			node.setValue(value);
		}
		
		return node;
	}
	
	public Integer get(String key) {
		
		Node node = get(rootNode,key,0);
		
		if(node == null) {
			return null;
		}
		
		return node.getValue();
	}

	public Node get(Node node, String key, int index) {
		
		if(node == null) {
			return null;
		}
		
		char c = key.charAt(index);
		
		if(c<node.getCharacter()) {
			return get(node.getLeftNode(), key, index);
		}else if(c > node.getCharacter()) {
			return get(node.getRightNode(),key,index);
		}else if(index< key.length() -1) {
			return get(node.getMiddleNode(), key, index+1);
		}else
			return node;
	}
}
