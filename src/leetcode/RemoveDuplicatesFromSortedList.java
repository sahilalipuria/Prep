/**
 * 
 */
package leetcode;

import leetcode.MergeTwoSortedLists.ListNode;

/**
 * @author salipuri
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 *
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode deleteDuplicates(ListNode head) {
        
    	if(head == null)
        	return head;
    	
    	ListNode currentElement = head;
        ListNode nextElement = head.next;
        
        
        while(nextElement != null) {
        	if(nextElement.val == currentElement.val)
        		nextElement = nextElement.next;
        	else {
        		currentElement.next = nextElement;
        		currentElement = nextElement;
        		nextElement = nextElement.next;
        	}
        }
        
        if(currentElement.next != null)
        	currentElement.next = null;
        	
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
