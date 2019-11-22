/**
 * 
 */
package random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author salipuri
 * 
 *  Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

	Example 1:
	
	Input: "bcabc"
	Output: "abc"
	Example 2:
	
	Input: "cbacdcbc"
	Output: "acdb"
 *
 */
public class RemoveDuplicateLetters {

	/**
	 * @param args
	 */
	public String removeDuplicateLetters(String s) {
        TreeMap<String,Character> charSet = new TreeMap<>();
        for(int i=0;i<s.length();i++) {
        	if(charSet.containsValue(s.charAt(i))) {
        		continue;
        	}
        	else {
        		charSet.put(String.format("\\u%04x", (int) s.charAt(i)),s.charAt(i));
        	}
        }
        s="";
        for(Character charValue: charSet.values()) {
        	s+= charValue;
        	
        }
        return s;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
		System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));

	}

}
