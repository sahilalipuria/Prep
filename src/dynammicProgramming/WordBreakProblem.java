/**
 * 
 */
package dynammicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author salipuri
 * 
 * The Word Break Problem
Objective : Given an string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of one or more dictionary words.
Example:
dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
String = "IamSumit"
Output: "I am Sumit"
String = "thisisadog"
Output : String can't be broken
 *
 */
public class WordBreakProblem {
	
	private String[] dictionary;
	private String word;
	private Map<String,Boolean> wordMap;

	public WordBreakProblem(String[] dictionary, String word) {
		this.dictionary = dictionary;
		this.word = word;
		this.wordMap = new HashMap<>();
	}

	public void solve() {
		
		for(String word: dictionary) {
			wordMap.put(word, false);
		}
		int startIndex = 0;
		int endIndex = 0;
		int count=0;
		
		while(endIndex<word.length()+1) {
			String subString = word.substring(startIndex, endIndex);
			
			if(startIndex == endIndex) {
				if(wordMap.containsKey(Character.toString(word.charAt(endIndex)))) {
					wordMap.put(Character.toString(word.charAt(endIndex)), true);
					startIndex++;
				}
			}
			else if(wordMap.containsKey(subString)) {
				wordMap.put(subString, true);
				startIndex = endIndex;
			}
			endIndex++;
		}
		
		for(String key: wordMap.keySet()) {
			if(wordMap.get(key)) {
				count += key.length();
				System.out.println(key);
			}
		}
		
		if(count!=word.length()) {
			System.out.println("NO SOLUTION FOUND");
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String dictionary[] = {"I" , "have", "Jain", "Sumit", "am", "this", "dog"};
		String word = "IamSumit";
		WordBreakProblem wordBreakProblem = new WordBreakProblem(dictionary, word);
		wordBreakProblem.solve();
	}

}
