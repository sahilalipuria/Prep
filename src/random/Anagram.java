/**
 * 
 */
package random;

import java.util.Arrays;

/**
 * @author salipuri
 * 
 * Write a function to check whether two given strings are anagram of each other or not. 
 * An anagram of a string is another string that contains same characters, only the order of characters can be different. 
 * For example, “abcd” and “dabc” are anagram of each other.
 *
 */
public class Anagram {

	/**
	 * @param args
	 */
	
	public boolean areAnagrams(String str1,String str2) {
		
		
		if(str1.toCharArray().length!=str2.toCharArray().length) {
			return false;
		}
		
		Arrays.sort(str1.toCharArray());
		Arrays.sort(str2.toCharArray());
		
		for(int i=0;i<str1.toCharArray().length;i++) {
			System.out.println(str1.toCharArray()[i]);
			System.out.println(str2.toCharArray()[i]);
			if(str1.toCharArray()[i] != str2.toCharArray()[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		System.out.println(anagram.areAnagrams("test", "ttew"));
		System.out.println(anagram.areAnagrams("test", "tset"));
		System.out.println(anagram.areAnagrams("abcd", "dabc"));

	}

}
