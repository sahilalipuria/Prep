/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 *
 */


 // Definition for singly-linked list. 
class ListNode { 
	int val; 
	ListNode next;
	ListNode(int x) { val = x; } 
}

public class MergeKSortedLists {

	/**
	 * @param args
	 */
	
	public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = new ListNode(0);
        ListNode temp = head;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(ListNode list: lists){
            while(list!=null){
                queue.add(list.val);
                list = list.next;
            }
        }
        
        while(!queue.isEmpty()){
            temp.next = new ListNode(queue.remove());
            temp = temp.next;
        }
        
        return head.next;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
