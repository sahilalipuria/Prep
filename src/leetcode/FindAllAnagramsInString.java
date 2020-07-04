/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author salipuri
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagramsInString {

	/**
	 * @param args
	 */
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        
        if(s.length()==0 || p.length()==0)
            return resultList;
        
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        p = new String(pArray);
        
        for(int i=0;i<s.length()-p.length()+1;i++){
        	char[] subString = s.substring(i, i+p.length()).toCharArray();
        	Arrays.sort(subString);
        	String toCompare = new String(subString);
        	if(toCompare.equals(p))
            	resultList.add(i);  
        }
        
        return resultList;
    }
	
	//We can also use sliding window approach 
	
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));

	}

}
