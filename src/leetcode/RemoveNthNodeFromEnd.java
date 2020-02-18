/**
 * 
 */
package leetcode;

import java.util.Stack;

import leetcode.MergeTwoSortedLists.ListNode;

/**
 * @author salipuri
 * 
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 *
 */
public class RemoveNthNodeFromEnd {

	/**
	 * @param args
	 */
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		Stack<ListNode> stack  = new Stack<>();
		ListNode dummy = null;
		
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty()) {
			n--;
			dummy = head;
			if(n==0)
				stack.pop();
			else {
                head = stack.pop();
				head.next = dummy;
			}
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
