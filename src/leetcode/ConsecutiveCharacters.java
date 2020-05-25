/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 1446. Consecutive Characters
 * 
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.
 *
 */
public class ConsecutiveCharacters {

	/**
	 * @param args
	 */
	
	public static int maxPower(String s) {
        int power =0;
        
        if(s.isEmpty())
        	return power;
        
        char currentChar = s.charAt(0);
        int counter = 1;
        
        for(int i=1;i<s.length();i++) {
        	if(s.charAt(i)==currentChar)
        		counter++;
        	else {
        		power = Math.max(power, counter);
        		currentChar = s.charAt(i);
        		counter=1;
        	}
        }
        
        power = Math.max(power, counter);
        
        return power;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(maxPower("leetcode"));
		System.out.println(maxPower("abbcccddddeeeeedcba"));
		System.out.println(maxPower("triplepillooooow"));
		System.out.println(maxPower("hooraaaaaaaaaaay"));
		System.out.println(maxPower("tourist"));
		
	}

}
