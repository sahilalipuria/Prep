/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortCharactersByFrequency {

	/**
	 * @param args
	 */
	
	public static String frequencySort(String s) {
		
		StringBuilder result = new StringBuilder();
		
		if(s.isEmpty())
			return result.toString();
		
		HashMap<Character,Integer> charMap = new HashMap<>();
		
		for(char c:s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> charMap.get(b)-charMap.get(a));
		maxHeap.addAll(charMap.keySet());
		
		char temp;
		int count=0;
		while(!maxHeap.isEmpty()) {
			temp = maxHeap.poll();
			count = charMap.get(temp);
			while(count>0) {
				result.append(temp);
				count--;
			}
		}
		
		return result.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}

}
