/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * @author salipuri
 *
 */
public class HappyNumber {

	/**
	 * @param args
	 * 
	 * Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.
Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
	 */
	
	public static boolean isHappy(int n) {
        int sum = 0;
        int lastDigit = 0;
        HashSet<Integer> seen = new HashSet<>();
        
        while(n != 1){
            sum = 0;
            while(n != 0){
                lastDigit = n%10;
                n = n/10;
                sum += lastDigit * lastDigit;
            }
            n = sum;
            if(seen.contains(n))
                return false;
            else
                seen.add(n);
        }
        return n == 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isHappy(1));
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));
		System.out.println(isHappy(34));
		System.out.println(isHappy(42));
		System.out.println(isHappy(32));
		System.out.println(isHappy(44));
	}

}
