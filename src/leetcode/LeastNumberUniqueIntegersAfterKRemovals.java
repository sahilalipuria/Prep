/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * 5454. Least Number of Unique Integers after K Removals
 * 
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:
Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
 *
 */
public class LeastNumberUniqueIntegersAfterKRemovals {

	/**
	 * @param args
	 */
	
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashSet<Integer> integerSet = new HashSet<>();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> minCountHeap = new PriorityQueue<>((a,b)->countMap.get(a)-countMap.get(b));
        
        for(int num: arr){
            if(!integerSet.contains(num)){
                integerSet.add(num);
            }
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        minCountHeap.addAll(integerSet);
        
        while(k>0) {
        	int element = minCountHeap.peek();
        	if(countMap.get(element)>0) {
        		int currentCount = countMap.get(element);
        		if(currentCount==1) {
        			countMap.remove(element);
        			integerSet.remove(element);
        			minCountHeap.poll();
        		}else {
        			countMap.put(element, currentCount-1);
        		}
        		k--;
        	}
        	
        }
        
        return integerSet.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findLeastNumOfUniqueInts(new int[] {5,5,4}, 1));
	}

}
