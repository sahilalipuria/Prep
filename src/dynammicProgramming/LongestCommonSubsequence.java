/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 *
 *
Objective: Given two string sequences, write an algorithm to find the length of longest subsequence present in both of them.
These kind of dynamic programming questions are very famous in the interviews like Amazon, Microsoft, Oracle and many more.
What is Longest Common Subsequence: A longest subsequence is a sequence that appears in the same relative order, but not necessarily contiguous(not substring) in both the string.
It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Example:

String A = "acbaed";
String B = "abcadf";

Longest Common Subsequence(LCS):     acad, Length: 4
 */
public class LongestCommonSubsequence {

	private String str1;
	private String str2;
	private int[][] dpTable;
	private String lcsSTring;
	
	public LongestCommonSubsequence(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
		dpTable = new int[str1.length()+1][str2.length()+1];
	}
	
	public void solve() {
		for(int i=0;i<=str1.length();i++) {
			dpTable[i][0] = 0;
		}
		
		for(int j=1;j<=str2.length();j++) {
			dpTable[0][j] = 0;
		}
		
		for(int rowIndex=1;rowIndex<=str1.length();rowIndex++) {
			for(int colIndex=1;colIndex<=str2.length();colIndex++) {
				if(str1.charAt(rowIndex-1) == str2.charAt(colIndex-1)) {
					dpTable[rowIndex][colIndex] = dpTable[rowIndex-1][colIndex-1]+ 1;
				}else {
					dpTable[rowIndex][colIndex] = Math.max(dpTable[rowIndex-1][colIndex], dpTable[rowIndex][colIndex-1]);
				}
			}
		}
		System.out.println(dpTable[str1.length()][str2.length()]);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "acbaed";
		String str2 = "abcadf";
		
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence(str1, str2);
		longestCommonSubsequence.solve();

	}

}
