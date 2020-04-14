/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"

Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
 *
 */
public class PerformStringShifts {

	/**
	 * @param args
	 */
	
	public static String stringShift(String s, int[][] shifts) {
        String result ="";
        int direction =0;
        int amount = 0;
        
        for(int[] shift: shifts){
            direction = shift[0];
            amount = shift[1];
            s = actualShift(s,direction,amount);
        }
        
        return s;
    }
    
    public static String actualShift(String s,int direction,int amount){
        Queue<Character> charQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        if(direction ==1) {	    									//right shift
        	for(int i=s.length()-1;i>s.length()-amount-1;i--) {
        		charQueue.add(s.charAt(i));
        	}
        	while(!charQueue.isEmpty()) {
        		sb.append(charQueue.poll());
        	}
            sb = sb.reverse();
        	for(int i=0;i<s.length()-amount;i++) {
        		sb.append(s.charAt(i));
        	}
        }else {														//left shift
        	for(int i=0;i<amount;i++) {
        		charQueue.add(s.charAt(i));
        	}
        	for(int i=amount;i<s.length();i++) {
        		sb.append(s.charAt(i));
        	}
        	while(!charQueue.isEmpty()) {
        		sb.append(charQueue.poll());
        	}
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("abc->"+stringShift("abc", new int[][] {{0,1},{1,2}}));
		System.out.println("abcdefg->"+stringShift("abcdefg", new int[][] {{1,1},{1,1},{0,2},{1,3}}));
	}

}
