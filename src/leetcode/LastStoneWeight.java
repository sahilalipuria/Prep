/**
 * 
 */
package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 *
 */
public class LastStoneWeight {

	/**
	 * @param args
	 */
	
	public static int lastStoneWeight(int[] stones) {
		int firstStone,secondStone,diff = 0;
		
		if(stones == null || stones.length == 0)
			return 0;
		
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone: stones) {
        	maxHeap.add(stone);
        }
        
        while(maxHeap.size() >1) {
        	firstStone = maxHeap.remove();
        	secondStone = maxHeap.remove();
        	diff = firstStone - secondStone;
        	if(diff >0)
        		maxHeap.add(diff);
        }
        
        if(maxHeap.size() == 1)
        	return maxHeap.remove();
        else
        	return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] stones = new int[]{2,7,4,1,8,1};
		int[] stones = new int[]{2,2};
		System.out.println(lastStoneWeight(stones));
	}

}
