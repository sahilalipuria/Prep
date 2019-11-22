/**
 * 
 */
package dynammicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author salipuri
 * 
 * We use DP and memoization in order to avoid recalculating a sub problem over and over again.
 * We should use an associative array abstract data type (Hash table) to store the solutions for subproblems //O(1)
 * On every f() method call -> we insert the calculated value if necessary
 * Why is it good? instead of exponential time complexity we will have O(n) time complexity + requires O(N) space
 * RECURSIVE: O(2^N), DP: O(N) space
 *
 */
public class FibonacciDP {

	/**
	 * @param args
	 */
	
	public int naiveFibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return naiveFibonacci(n-1)+ naiveFibonacci(n-2);
	}
	
	public Map<Integer, Integer> memoizeTable;
	
	public FibonacciDP() {
		this.memoizeTable = new HashMap<>();
		this.memoizeTable.put(0, 0);
		this.memoizeTable.put(1, 1);
	}
	
	public int fibonacciDp(int n) {
		if(this.memoizeTable.containsKey(n))
			return this.memoizeTable.get(n);
		
		this.memoizeTable.put(n-1, fibonacciDp(n-1));
		this.memoizeTable.put(n-2, fibonacciDp(n-2));
		
		int calculateNumber = this.memoizeTable.get(n-1)+this.memoizeTable.get(n-2);
		this.memoizeTable.put(n, calculateNumber);
		return calculateNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FibonacciDP fibonacciDP = new FibonacciDP();
		System.out.println("NAIVE:  "+fibonacciDP.naiveFibonacci(40));
		System.out.print("DP: " + fibonacciDP.fibonacciDp(40));
	}

}
