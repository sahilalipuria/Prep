/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 66. Plus One
 * 
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 *
 */
public class PlusOne {

	/**
	 * @param args
	 */
	
	public static int[] plusOne(int[] digits) {
        int carry = 0;
        if(digits.length!=0){
            digits[digits.length-1] ++;
            
            for(int i=digits.length-1;i>=0;i--){
            if(carry!=0){
                digits[i]++;
                carry = 0;
            }
            if(digits[i]>9){
                digits[i] = 0;
                carry++;
            }
        }
        }
        if(carry!=0 || digits.length==0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for(int i=1;i<result.length;i++) {
                result[i] = digits[i-1];
            	//System.out.print(result[i]);
            }
            
            return result;
        }
        
        return digits;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(plusOne(new int[] {1,2,3}));
		System.out.println(plusOne(new int[] {9}));
		System.out.println(plusOne(new int[] {}));
	}

}
