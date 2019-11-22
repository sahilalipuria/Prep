package trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private Node root;
	private int indexOfSingleChild;

	public Trie() {
		super();
		this.root = new Node("");
	}
	
	public void insert(String word,int value) {
		
		Node tempNode  = root;
		
		for(int i=0;i<word.length();i++) {
			
			char c = word.charAt(i);
			int asciiIndex = c - 'a';
			
			if(tempNode.getChild(asciiIndex)==null) {
			
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, node, value);
				tempNode = node;
			}
			else {
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		
		tempNode.setLeaf(true);
	}
	
	public boolean search(String word) {
		
		Node trieNode = root;
		
		for(int i=0;i<word.length();i++) {
			
			char c = word.charAt(i);
			int asciiIndex = c - 'a';
			
			if(trieNode.getChild(asciiIndex)==null) {
				return false;
			}else {
				trieNode = trieNode.getChild(asciiIndex);
			}
		}
		
		//if(!trieNode.isLeaf()) return false	
		return true;					// we will check for substrings existence also
	}
	
	public Integer searchAsMap(String word) {
		
		Node trieNode = root;
		
		for(int i=0;i<word.length();i++) {
			
			char c = word.charAt(i);
			int asciiIndex = c - 'a';
			
			if(trieNode.getChild(asciiIndex)!=null) {
				trieNode = trieNode.getChild(asciiIndex);
			}else {
				return null;
			}
		}
		
		//if(!trieNode.isLeaf()) return false	
		return trieNode.getValue();					// we will check for substrings existence also
	}
	
	public List<String> allWordsWithPrefix(String prefix){
		
		Node trieNode = root;
		List<String> stringContainingPrefix = new ArrayList<>();
		
		for(int i =0;i<prefix.length();i++) {
			
			char c = prefix.charAt(i);
			int asciiValue = c - 'a';
			
			trieNode = trieNode.getChild(asciiValue);
		}
		
		collect(trieNode,prefix,stringContainingPrefix);
		
		return stringContainingPrefix;
	}

	private void collect(Node node, String prefix, List<String> stringContainingPrefix) {
		if(node == null) {
			return;
		}
		
		if(node.isLeaf()) {
			stringContainingPrefix.add(prefix);
		}
		
		for(Node childNode: node.getChildern()) {
			if(childNode == null) continue;
			String childCharacter = childNode.getCharacter();
			collect(childNode, prefix+childCharacter, stringContainingPrefix);
		}
		
	}
	
	public String longestCommonPrefix() {
		
		Node trieNode = root;
		String lcp = "";
		
		while(countOfChildren(trieNode) == 1 && !trieNode.isLeaf()) {
			trieNode = trieNode.getChild(indexOfSingleChild);
			
			lcp += String.valueOf((char) (indexOfSingleChild + 'a'));
		}
		
		return lcp;
	}

	private int countOfChildren(Node trieNode) {
		
		int numOfChildren = 0;
		for(int i=0;i<trieNode.getChildern().length;i++) {
			if(trieNode.getChild(i)!=null) {
				numOfChildren++;
				indexOfSingleChild = i;
			}
		}
		
		return numOfChildren;
	}
	
}
