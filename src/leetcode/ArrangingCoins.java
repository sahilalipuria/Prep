/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 441. Arranging Coins
 *
 *You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
Given n, find the total number of full staircase rows that can be formed.
n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
n = 5
The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.

Example 2:
n = 8
The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

	/**
	 * @param args
	 */

	public static int arrangeCoins(int n) {
		long left = 0, right = n;
		long k, curr;
		while (left <= right) {
			k = left + (right - left) / 2;
			curr = k * (k + 1) / 2;

			if (curr == n)
				return (int) k;

			if (n < curr) {
				right = k - 1;
			} else {
				left = k + 1;
			}
		}
		return (int) right;
	}

	public static int arrangeCoinsNonOptimized(int n) {
		int result = 0;

		if (n == 0)
			return result;

		int i = 0;
		while (n > 0) {
			i++;
			if (n >= i) {
				n -= i;
				result++;
			} else {
				n = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(arrangeCoins(5));
		System.out.println(arrangeCoinsNonOptimized(5));
	}

}
