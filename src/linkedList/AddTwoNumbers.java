/**
 * 
 */
package linkedList;

/**
 * @author salipuri
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 *
 */

// Definition for singly-linked list.
class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int l1Length = 0;
        int l2Length = 0;
        ListNode l3;
        int sum=0;
        int carier = 0;
        
        l3 = l1;
        while(l1!= null && l2!= null) {
        	sum = l1.val+l2.val;
        	if(carier!=0) {
        		sum++;
        		carier--;
        	}
        	if(sum%10==0) {
        		if(l1.val==0 && l2.val==0) {
        			l1.val =0;
        		}else {
        			l1.val = 0;
        			carier++;
        		}
        	}else {
        		l1.val = sum%10;
        		if((sum/10)>0) {
        			carier++;
        		}
        	}
        	if(l1.next == null && l2.next==null) {
        		break;
        	}
        	else {
        		if(l1.next == null) {
        			ListNode newNode = new ListNode(0);
        			l1.next = newNode;
        		}
        		else if(l2.next == null) {
        			ListNode newNode = new ListNode(0);
        			l2.next = newNode;
        		} 
	        	l1 = l1.next;
	        	l2 = l2.next;
        	}
        }
        if(carier!=0) {
    		l1.next = new ListNode(1);
    		l1 = l1.next;
    	}
        
        return l3;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = new ListNode(1);
		//l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(7);
		l2.next.next = new ListNode(8);
		
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
		
		while(l3!=null) {
			System.out.println(l3.val+" ");
			l3 = l3.next;
		}

	}

}
