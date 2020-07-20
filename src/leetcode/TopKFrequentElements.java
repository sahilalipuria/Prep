/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * 347. Top k Frequent Elements
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

 *
 */
public class TopKFrequentElements {

	/**
	 * @param args
	 */
	
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                                        (a,b)->map.get(b)-map.get(a));
        int[] result = new int[k];
        
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        maxHeap.addAll(map.keySet());
        
        int index=0;
        while(k-->0){
            result[index++] = maxHeap.poll();
            System.out.print(result[index-1]+" ");
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(topKFrequent(new int[] {1,1,1,2,2,3}, 2));
	}

}
