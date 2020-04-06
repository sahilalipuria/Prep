/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author salipuri
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 *
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        
		List<List<String>> groups = new ArrayList<List<String>>();
		HashMap<String, List<String>> stringsMap = new HashMap<>();
		
		for(String str: strs) {
			char[] characters = str.toCharArray();
			Arrays.sort(characters);
			String sorted = new String(characters);
			if(!stringsMap.containsKey(sorted))
				stringsMap.put(sorted, new ArrayList<>());
				
			stringsMap.get(sorted).add(str);
		}
 		
		groups.addAll(stringsMap.values());
		
		return groups;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(groupAnagrams(strs));

	}

}
