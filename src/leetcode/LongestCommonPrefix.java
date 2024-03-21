package Leetcode;

import java.util.Arrays;

/**
 * @author salipuri
 *
 *
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        String prefix = "";
        Arrays.sort(strs);
        String smallest = strs[0];
        String longest = strs[strs.length-1];
        int index = 0;
        while(index<smallest.length()){
            if(smallest.charAt(index)==longest.charAt(index))
                index++;
            else {
                break;
            }
        }
        return smallest.substring(0,index);
    }
    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
}
