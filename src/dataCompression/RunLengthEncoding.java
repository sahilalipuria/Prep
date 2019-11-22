package dataCompression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {
	
	public static String encode(String pattern) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i=0;i<pattern.length();i++) {
			int runLength = 1;
			
			while(i+1<pattern.length() && pattern.charAt(i) == pattern.charAt(i+1)) {
				
				runLength++;
				i++;
			}
			
			stringBuilder.append(runLength);
			stringBuilder.append(pattern.charAt(i));
			
		}
		
		return stringBuilder.toString();
	}
	
	public static String decode(String compressedText) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(compressedText);
		
		while(matcher.find()) {
			
			int runLength = Integer.parseInt(matcher.group());
			matcher.find();
			
			while(runLength-- !=0) {
				stringBuilder.append(matcher.group());		//4A----->AAAA
			}
		}
		
		return stringBuilder.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = encode("AAABBCAAFFFF");
		System.out.println(s);
		s = decode("3A2B1C2A4F");
		System.out.println(s);

	}

}
