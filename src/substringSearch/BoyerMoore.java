/**
 * 
 */
package substringSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author salipuri
 * 
 *
 *The Boyer-Moore algorithm is consider the most efficient string-matching algorithm in usual applications, for example, in text editors and commands substitutions. 
 *The reason is that it works the fastest when the alphabet is moderately sized and the pattern is relatively long.

The algorithm scans the characters of the pattern from right to left beginning with the rightmost character. 
During the testing of a possible placement of pattern P against text T, a mismatch of text character T[i] = c with the corresponding pattern character P[j] is handled as follows: 
If c is not contained anywhere in P, then shift the pattern P completely past T[i]. Otherwise, shift P until an occurrence of character c in P gets aligned with T[i].

This technique likely to avoid lots of needless comparisons by significantly shifting pattern relative to text.

It is another approach of Boyer Moore Algorithm. Sometimes it is called the Good Suffix Heuristic method. 
For this case, a preprocessing table is created as suffix table. 
In this procedure, the substring or pattern is searched from the last character of the pattern. 
When a substring of main string matches with a substring of the pattern, it moves to find other occurrences of the matched substring. 
It can also move to find a prefix of the pattern which is a suffix of main string. Otherwise, it moves the whole length of the pattern.
 
 Input:
Main String: “ABAAABCDBBABCDDEBCABC”, Pattern: “ABC”
Output:
Pattern found at position: 4
Pattern found at position: 10
Pattern found at position: 18
 */
public class BoyerMoore {
	
	private String text;
	private String pattern;
	private Map<Character,Integer> mismatchShiftTable;
	
	public BoyerMoore(String text, String pattern) {
		super();
		this.text = text;
		this.pattern = pattern;
		this.mismatchShiftTable = new HashMap<>();			//bad-match table from pattern
	}
	
	public void precomputeShift() {
		int lengthOfPattern = this.pattern.length();
		for(int index=0;index<lengthOfPattern;index++) {
			int maxShift = Math.max(1, lengthOfPattern-index-1);			//value for bad match table for that character in pattern
			char actualChar = this.pattern.charAt(index);
			mismatchShiftTable.put(actualChar, maxShift);
		}
	}

	public int search() {
		
		int lengthOfPattern = this.pattern.length();
		int lengthOfText = this.text.length();
		int numOfSkips;
		
		for(int i=0;i<=lengthOfText-lengthOfPattern;i=i+numOfSkips) {
			numOfSkips =0;
			
			for(int j=lengthOfPattern-1;j>=0;j--) {
				if(pattern.charAt(j)!= text.charAt(i+j)) {
					
					if(this.mismatchShiftTable.get(text.charAt(i+j))!=null) {
						numOfSkips = this.mismatchShiftTable.get(text.charAt(i+j));
						break;
					}else {
						numOfSkips = lengthOfPattern;
						break;
					}
				}
			}
			if(numOfSkips==0) 
				return i;
		}
		return lengthOfText;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "My name is Joe";
		String pattern = "ame";
		
		BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
		boyerMoore.precomputeShift();
		System.out.println(boyerMoore.search());

	}

}
