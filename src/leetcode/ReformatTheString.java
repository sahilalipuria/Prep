/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author salipuri
 * 
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
 *
 */
public class ReformatTheString {

	/**
	 * @param args
	 */
	
	 public static String reformat(String s) {
	        
	        String result = "";
	        
	        if(s == "" || s == null)
	            return result;
	        
	        Stack<Character> lettersStack = new Stack<>();
	        Stack<Character> numbersStack = new Stack<>();
	        
	        for(char currentChar: s.toCharArray()){
	        	if(Math.abs(currentChar - 'a') < 26){
	            	lettersStack.push(currentChar);
	            }else {
	            	numbersStack.push(currentChar);
	            }
	        }
	        
	        if(!(Math.abs(numbersStack.size()-lettersStack.size())>1)) {
	        	if(s.charAt(0) - 'a' < 26) {
	        		Stack<Character> tempStack = new Stack<>();
	        		
	        		tempStack = lettersStack;
	        		lettersStack = numbersStack;
	        		numbersStack = tempStack;
	        		
	        	}
	        	
	        	while(!lettersStack.isEmpty() && !numbersStack.isEmpty()) {
	        		if(lettersStack.size() >= numbersStack.size()) {
	        			result += lettersStack.pop();
		        		result += numbersStack.pop();
	        		}else {
	        			result += numbersStack.pop();
	        			result += lettersStack.pop();
	        		}
	        	}
	        	
	        	if(!lettersStack.isEmpty())
	        		result += lettersStack.pop();
	        	
	        	if(!numbersStack.isEmpty())
	        		result += numbersStack.pop();
	        	
	        }
	        
	        return result;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("a0b1c2:"+reformat("a0b1c2"));
		System.out.println("leetcode:"+reformat("leetcode"));
		System.out.println("1229857369:"+reformat("1229857369"));
		System.out.println("covid2019:"+reformat("covid2019"));
		System.out.println("ab123:"+reformat("ab123"));

	}

}
