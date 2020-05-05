/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author salipuri
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 *
 */
public class FirstUniqueCharacterInString {

	/**
	 * @param args
	 */
	
	public static int firstUniqChar(String s) {
		
		if(s.isEmpty())
			return -1;
        
        int result = Integer.MAX_VALUE;
        HashSet<Character> uniqueSet = new HashSet<>();
        HashSet<Character> nonUniqueSet = new HashSet<>();
        int[] characters = new int[26];
        char[] character = s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(uniqueSet.contains(character[i])){
                uniqueSet.remove(character[i]);
                nonUniqueSet.add(character[i]);
            }else if(nonUniqueSet.contains(character[i])){
                continue;
            }else{
                uniqueSet.add(character[i]);
                characters[character[i]-'a'] = i;
            }
        }
        
        if(uniqueSet.isEmpty())
        	return -1;
        
        for(char key:uniqueSet) {
        	result = Math.min(result, characters[key-'a']);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(firstUniqChar(""));
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("cc"));
	}

}
