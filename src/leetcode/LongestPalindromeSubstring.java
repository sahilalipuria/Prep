package Leetcode;

import java.util.Arrays;

/**
 * @author salipuri
 *
 *
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class LongestPalindromeSubstring {

    private static int startIndex;
    private static int strLength;

    public static String longestPalindrome(String s) {

        if(s.length()< 2) return s;

        for(int i=0;i<s.length()-1;i++){
            expandRange(s,i,i);
            expandRange(s,i,i+1);
        }

        return s.substring(startIndex,startIndex+strLength);
    }

    private static void expandRange(String s, int begin, int end) {
        while(begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)){
            begin--;
            end++;
        }

        if(strLength<end-begin-1){
            startIndex = begin+1;
            strLength = end-begin-1;
        }
    }

    public static void main(String[] args) {

        String strs = new String("babad");
        longestPalindrome(strs);
    }
}
