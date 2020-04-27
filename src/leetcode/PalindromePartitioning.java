/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author salipuri
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 *
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	
	private static void addPalindrome(String s, int start, List<String> partition,
			List<List<String>> result) {
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
	 
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				//System.out.println(str+" is a palindrome");
				partition.add(str); 
				addPalindrome(s, i, partition, result);
				//System.out.println("--------"+partition);
				//System.out.println("Removing "+partition.get(partition.size()-1));
				partition.remove(partition.size() - 1);
			}
		}
	}
	 
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
	 
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
	 
			left++;
			right--;
		}
	 
		return true;
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		 
		if (s == null || s.length() == 0) {
			return result;
		}
	 
		ArrayList<String> partition = new ArrayList<String>();//track each possible partition
		addPalindrome(s, 0, partition, result);
	 
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(partition("aab"));
		//System.out.println(partition("aaa"));
		//System.out.println(partition("abba"));
	}

}
