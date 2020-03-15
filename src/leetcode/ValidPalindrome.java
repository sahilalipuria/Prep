package leetcode;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		
		if(s == "") return true;
        
		int i = 0,j = s.length()-1;
		
		while(i<j) {
			
			while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			
			while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			
			i++ ;
			j--;
		}
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));

	}
}
