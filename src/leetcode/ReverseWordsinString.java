/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 151. Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.

Example 1:
Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Follow up:

For C programmers, try to solve it in-place in O(1) extra space.
 *
 */
public class ReverseWordsinString {

	/**
	 * @param args
	 */
	
	public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].isEmpty()){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  hello world!  "));
	}

}
