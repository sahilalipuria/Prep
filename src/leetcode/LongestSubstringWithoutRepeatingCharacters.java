/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 *
 *Given a string, find the length of the longest substring without repeating characters.

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
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	
	public static int lengthOfLongestSubstring(String s) {
        
		if(s.isEmpty())
			return 0;
		
		int result = 1;
        int[] charArray = new int[26];
        int currentMax = 0;
        s = s.trim();
        
        for(int i=0;i<s.length();i++) {
        	if(charArray[Math.abs(s.charAt(i)-'a')]==0) {
        		charArray[Math.abs(s.charAt(i)-'a')] = i;
        		currentMax++;
        	}else {
        		result = Math.max(result,currentMax);
        		currentMax=1;
        		if(charArray[Math.abs(s.charAt(i)-'a')])
        	}
        }
        
        result = Math.max(result,currentMax);
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("dvdf"));
		
		
	}

}
