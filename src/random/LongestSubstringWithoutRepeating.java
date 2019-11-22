/**
 * 
 */
package random;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeating {

	/**
	 * @param args
	 */
	
	public int lengthOfLongestSubstring(String s) {
		
		int globalMax = 1;
		int currentMax = 1;
		int startIndex = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		
		for(int i=startIndex;i<s.length();i++) {
			//System.out.println(i);
			if(!hashMap.containsKey(s.charAt(i))) {
				hashMap.put(s.charAt(i), i);
				currentMax++;
				System.out.println("Iterating over: "+s.charAt(i)+" with currentMax:"+currentMax+" globalMax:"+globalMax+" i:"+i+" startIndex:"+startIndex);
			}else {
				System.out.println("Contains: "+s.charAt(i)+" with currentMax:"+currentMax+" globalMax:"+globalMax+" i:"+i+" startIndex:"+startIndex);
				if(hashMap.get(s.charAt(i))>=startIndex){
					hashMap.put(s.charAt(i), i);
					if(currentMax>globalMax) {
						globalMax = currentMax;
						currentMax=1;
						//i=startIndex;
						startIndex++;
						//i = startIndex-1;
					}
				}else {
					hashMap.put(s.charAt(i), i);
					currentMax++;
				}
			}
		}
		if(currentMax>globalMax) {
			globalMax = currentMax;
		}
		return globalMax;
    }
	public static void main(String[] args) {
		LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("bbbbb"));
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("pwwkew"));
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("aab"));
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring(" "));
		System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("dvdf"));

	}

}
