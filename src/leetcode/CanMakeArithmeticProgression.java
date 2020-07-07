package leetcode;

import java.util.PriorityQueue;

/*
 * 1502. Can Make Arithmetic Progression From Sequence
 * 
 * Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

 

Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 

Constraints:

2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */

public class CanMakeArithmeticProgression {

	public static boolean canMakeArithmeticProgression(int[] arr) {
        
        if(arr.length==0 || arr.length==1)
            return false;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int num:arr)
            queue.add(num);
       
        int currentDifference = queue.poll()-queue.peek();
        while(queue.size()>1){
            int current = queue.poll();
            if((current-queue.peek())!=currentDifference)
                return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(canMakeArithmeticProgression(new int[] {3,5,1}));
	}

}
