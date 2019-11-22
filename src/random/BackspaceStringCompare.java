/**
 * 
 */
package random;

/**
 * @author salipuri
 *
 */
public class BackspaceStringCompare {

	/**
	 * @param args
	 * 
	 *  Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
		Example 1:
		Input: S = "ab#c", T = "ad#c"
		Output: true
		Explanation: Both S and T become "ac".
		
		Example 2:
		Input: S = "ab##", T = "c#d#"
		Output: true
		Explanation: Both S and T become "".
		
		Example 3:
		Input: S = "a##c", T = "#a#c"
		Output: true
		Explanation: Both S and T become "c".
		
		Example 4:
		Input: S = "a#c", T = "b"
		Output: false
		Explanation: S becomes "c" while T becomes "b".
		
		Note:
		1 <= S.length <= 200
		1 <= T.length <= 200
		S and T only contain lowercase letters and '#' characters.
		
		Follow up:
		Can you solve it in O(N) time and O(1) space?
	 */
		public static String removeBackspaces(String s) {
			int charToRemove =0;
			String trimmedString="";
			
			for(int i=s.length()-1;i>=0;i--) {
				if(s.charAt(i)=='#') charToRemove++;
				
				if(s.charAt(i)!='#') {
					if(charToRemove!=0)
					{
						charToRemove--;
					}
					else {
						trimmedString += s.charAt(i);
					}
				}
			}
			return trimmedString;
		}
	
	public static boolean backspaceCompare(String S, String T) {
		
			
			return (removeBackspaces(S).equals(removeBackspaces(T)));
		        
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
		System.out.println(backspaceCompare("ab#c", "ad#c"));

	}

}
