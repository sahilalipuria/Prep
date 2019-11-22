/**
 * 
 */
package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author salipuri
 *
 */
public class StringOperations {

	/**
	 * @param args
	 */
	
	public String reverseString(String text) {
		
		//String => O(N*N) whereas StringBuilder => O(N)
		int length = text.length();		//O(1)
		StringBuilder reveresedString = new StringBuilder();
		for(int index = length-1;index>=0;index--) {				//O(N)
			reveresedString.append(text.charAt(index));				//O(1)
		}															//O(N)+O(1)  ~=O(N)
		
		return reveresedString.toString();
	}
	
	public List<String> getSuffixes(String text){
		
		int length = text.length();		//O(1)
		List<String> suffixesList = new ArrayList<>();
		for(int index=0;index<length;index++) {
			suffixesList.add(text.substring(index, length));
		}
		
		return suffixesList;
	}
	
	public List<String> getPrefixes(String text){
		
		int length = text.length();		//O(1)
		List<String> preffixesList = new ArrayList<>();
		for(int index=1;index<length+1;index++) {			//O(N)
			preffixesList.add(text.substring(0, index));	//O(1)
		}
		return preffixesList;
	}
	
	public String longestCommonPrefix(String s1,String s2) {
		
		int commonLength = Math.min(s1.length(), s2.length());
		
		for(int index=0;index<commonLength;index++) {
			if(s1.charAt(index)!=s2.charAt(index))
				return s1.substring(0, index);
		}
		
		return s1.substring(0,commonLength);
	}
	
	public String longestRepeatedSubString(String text) {
		
		int lengthOfText = text.length();
		
		List<String> suffixList = getSuffixes(text);
		Collections.sort(suffixList);
		
		String longestSubstring	= "";
		
		for(int i=0;i<lengthOfText-1;i++) {
			
			String tempString = longestCommonPrefix(suffixList.get(i), suffixList.get(i+1));
			System.out.println("Cmparing prefixes: "+suffixList.get(i)+"-"+suffixList.get(i+1)+",common prefix:"+tempString);
			
			if(tempString.length()>longestSubstring.length()) {
				longestSubstring = tempString;
			}
		}
		
		return longestSubstring;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringOperations stringOperations = new StringOperations();
		
		System.out.println(stringOperations.reverseString("Hello Word!"));
		System.out.println("racecar-~" + stringOperations.reverseString("racecar"));
		if("racecar".equals(stringOperations.reverseString("racecar"))) {
			System.out.println("Racecar is a palindrome");
		}
		
		List<String> suffixes = stringOperations.getSuffixes("Hello");
		
		System.out.println("SUFFIXES:");
		for(String s:suffixes) {
			System.out.println(s);
		}
		System.out.println(suffixes.size());		//Longest substring problem
		
		List<String> preffixes = stringOperations.getPrefixes("House");
		
		System.out.println("PREFFIXES:");
		for(String s:preffixes) {
			System.out.println(s);
		}
		System.out.println(preffixes.size());		//Longest substring problem
		
		System.out.println("Longest common prefix:"+ stringOperations.longestCommonPrefix("Helo", "Hello"));
		
		System.out.println("Longest common substring for hellohehehehehello: "+stringOperations.longestRepeatedSubString("hellohehehehehello"));
		System.out.println("Longest common substring for hellohehehello: "+stringOperations.longestRepeatedSubString("hellohehehello"));
	}

}
