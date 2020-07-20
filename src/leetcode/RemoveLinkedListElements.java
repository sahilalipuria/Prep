/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 203. Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 *
 */
public class RemoveLinkedListElements {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	
	public ListNode removeElements(ListNode head, int val) {
        
        if(head == null)
            return head;
        
        if(head.val == val){
            while(head!=null && head.val==val){
                head = head.next;
            }
        }
        
        ListNode current = head;
        ListNode previous = null;
        
        while(current!=null){
            if(current.val==val){
                previous.next = current.next;
                current = current.next;
            }else{
                previous = current;
                current = current.next;
            }   
        }   
            
        return head;    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
