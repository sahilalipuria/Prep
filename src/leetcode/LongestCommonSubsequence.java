/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	
	public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dpTable = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<=text2.length();i++)
        	dpTable[0][i] = 0;
        
        for(int i=0;i<=text1.length();i++)
        	dpTable[i][0] = 0;
        
        for(int i=1;i<=text1.length();i++) {
        	for(int j=1;j<=text2.length();j++) {
        		if(text1.charAt(i-1)==text2.charAt(j-1)) {
        			dpTable[i][j] = dpTable[i-1][j-1]+1;
        		}else {
        			dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i][j-1]);
        		}
        	}
        }
        
        return dpTable[text1.length()][text2.length()];   	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestCommonSubsequence("abcde", "ace"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
		System.out.println(longestCommonSubsequence("abc", "def"));
		System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
		System.out.println(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
	}

}
