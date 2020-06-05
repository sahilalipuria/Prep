/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * @author salipuri
 *
 *345. Reverse Vowels of a String
 *
 *Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */
public class ReverseVowelsInString {

	/**
	 * @param args
	 */
	
public static String reverseVowels(String s) {
        
        if(s.isEmpty())
            return s;
        
        HashSet<Character> vowelSet = new HashSet<>();
        
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        
        int i=0;
        int j=s.length()-1;
        
        char[] charArray = s.toCharArray();
        while(i<j){
            while(!vowelSet.contains(Character.toLowerCase(charArray[i])) && i<s.length()-1)
                i++;
            
            while(!vowelSet.contains(Character.toLowerCase(charArray[j])) && j>0)
                j--;
            
            if(i<j){
                char temp = charArray[i];
                charArray[i++] = charArray[j];
                charArray[j--] = temp;
            }
        }
        
        StringBuilder newString = new StringBuilder();
        
        for(char c:charArray)
            newString.append(c);
        
        return newString.toString();
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("aA"));
		System.out.println(reverseVowels(".,"));
	}

}
