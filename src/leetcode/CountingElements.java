/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

 

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
 

Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
 *
 */
public class CountingElements {

	/**
	 * @param args
	 */
	
	public static int countElements(int[] arr) {
        
		HashMap<Integer, Integer> numMap = new HashMap<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
		int result = 0;
		
		for(int num: arr) {
			numMap.put(num, numMap.getOrDefault(num, 0)+1);
			if(!maxHeap.contains(num))
				maxHeap.add(num);
		}
		
		int removed = 0;
		while(maxHeap.size()>1) {
			removed = maxHeap.poll();
			if((removed-maxHeap.peek())==1) {
				result += numMap.get(maxHeap.peek());
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Result:"+countElements(new int[] {1,2,3}));
		System.out.println("Result:"+countElements(new int[] {1,1,3,3,5,5,7,7}));
		System.out.println("Result:"+countElements(new int[] {1,3,2,3,5,0}));
		System.out.println("Result:"+countElements(new int[] {1,1,2,2}));

	}

}
