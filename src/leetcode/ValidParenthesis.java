/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author salipuri
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 *
 */
public class ValidParenthesis {

	public static boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(Character bracket: s.toCharArray()) {
        	
        	if(bracket == '(' || bracket == '{' || bracket == '[') {
        		stack.push(bracket);
        	}else if(bracket == ')' && !stack.isEmpty() && stack.peek()=='(') {
        		stack.pop();
        	}else if(bracket == '}' && !stack.isEmpty() && stack.peek()=='{') {
        		stack.pop();
        	}else if(bracket == ']' && !stack.isEmpty() && stack.peek()=='[') {
        		stack.pop();
        	}else
        		return false;
        }
        
        if(!stack.isEmpty())
        	return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("["));

	}

}
