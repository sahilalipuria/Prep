package random;

public class Palindrome {

	public static boolean palindrome1(String s) {
		StringBuilder reversed = new StringBuilder();
		int stringLength = s.length();
		for(int i=stringLength;i>0;i--) {
			reversed.append(s.charAt(i-1));
		}
		if(s.equals(reversed.toString()))
			return true;
		else
			return false;
	}
	
	public static boolean palindrome2(String s) {
		int startIndex = 0;
		int endIndex = s.length() -1;
		int middleIndex = (startIndex+endIndex)/2;
		
		for(int i=startIndex;i<=middleIndex;i++) {
			if(s.charAt(i)!=s.charAt(endIndex-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome1("abba"));
		System.out.println(palindrome2("abba"));

	}

}
