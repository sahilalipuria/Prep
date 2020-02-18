/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/**
 * @author salipuri
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 */
public class ReverseNodesInKGroups {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	public ListNode reverseKGroup(ListNode head, int k) {
        
		if(k == 0) return head;
		
		ListNode firstPointer = head;
		ListNode temp = new ListNode(-1);
		Stack<ListNode> stack  = new Stack<>();
		int count = 0;
		
		while(firstPointer!=null) {
			count++;
			firstPointer = firstPointer.next;
		}
		firstPointer = head;
		head = temp;
		for(int i=1;i<=count/k;i++) {
			for(int j=1;j<=k;j++) {
                stack.add(firstPointer);
				firstPointer = firstPointer.next;
			}
			while(!stack.isEmpty()) {
				temp.next = stack.pop();
				temp = temp.next;
                System.out.println(temp.val);
			}
		}
        
        if(count%k!=0)
			temp.next = firstPointer;
        else
            temp.next = null;
			
		return head.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
