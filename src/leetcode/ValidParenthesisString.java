/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author salipuri
 *
 *Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {

	/**
	 * @param args
	 */
	
	public static boolean checkValidString(String s) {
		Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else 
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop()) 
                return false;
        }
        return leftID.isEmpty();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString(")("));
		System.out.println(checkValidString(")"));*/
		System.out.println("(())((())()()(*)(*()(())())())()()((()())((()))(*");
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

}
