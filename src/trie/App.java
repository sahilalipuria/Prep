package trie;

import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		/*trie.insert("joe");
		trie.insert("joell");
		trie.insert("adamovich");
		trie.insert("helloworld");*/
		
		//trie.insert("joe",1);
		trie.insert("adam",2);
		trie.insert("adamovich",3);
		//trie.insert("helloworld",4);
		trie.insert("ada",5);
		
		//System.out.println(trie.search("joee"));
		//System.out.println(trie.search("joell"));
		
		System.out.println(trie.searchAsMap("adamovich"));
		
		List<String> words = trie.allWordsWithPrefix("a");
		
		for(String word: words) {
			System.out.println(word);
		}

		System.out.println("-------SORTED-----------");
		words = trie.allWordsWithPrefix("");
		
		for(String word: words) {
			System.out.println(word);
		}
		
		System.out.println("LCP: "+trie.longestCommonPrefix());
	}

}
