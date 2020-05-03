/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author salipuri
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 *
 */
public class RansomNote {

	/**
	 * @param args
	 */
	
	public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> charMap = new HashMap<>();
        
        for(char character: magazine.toCharArray()){
            charMap.put(character,charMap.getOrDefault(character, 0)+1);
        }
        
        for(char character: ransomNote.toCharArray()){
            if(charMap.containsKey(character)){
            	int value = charMap.get(character);
                if(value!=0){
                    charMap.put(character, value-1);
                }else
                    return false;
            }else
                return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));

	}

}
