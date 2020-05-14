/**
 * 
 */
package leetcode;

import java.util.Stack;

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


public class AddTwoNumbers {

	
	 // Definition for singly-linked list. 
	class ListNode { 
		int val; 
		ListNode next; 
		ListNode(int x) { val = x; }
	}
	 
	
	
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        
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
	
	public ListNode appendNode(int sum,ListNode head) {
		ListNode dummy = new ListNode(sum);
		head.next = dummy;
		head = head.next;
		return head;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tempPointer = head;
		
		Stack<Integer> l1Stack = new Stack<>();
		Stack<Integer> l2Stack = new Stack<>();
		int carry = 0;
        
        int l1Length = 0;
        int l2Length = 0;
		
        tempPointer = l1;
		while(tempPointer!=null) {
			tempPointer = tempPointer.next;
            l1Length++;
            System.out.println("L1 next");
		}
		
        tempPointer = l2;
		while(tempPointer!=null) {
			tempPointer = tempPointer.next;
            l2Length++;
		}
		
		if(l1Length>l2Length) {
			while(l2Length!=l1Length){
				l2Stack.push(0);
                System.out.println("Pushing in l2 stack 0");
				l2Length++;
			}
            
		}else if(l2Length>l1Length) {
			while(l1Length!=l2Length){
				l1Stack.push(0);
                System.out.println("Pushing in l1 stack 0");
				l1Length++;
			}
		}
		
        while(l1!=null){
                System.out.println("Pushing in l1 stack "+l1.val);
                l1Stack.push(l1.val);
                l1 = l1.next;
            }
        
        while(l2!=null){
                System.out.println("Pushing in l2 stack "+l2.val);
                l2Stack.push(l2.val);
                l2 = l2.next;
            }
        
		int sum;
        tempPointer = head;
		while(!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
			sum = (l1Stack.peek()+l2Stack.peek() + carry)%10;
			carry = (l1Stack.pop()+l2Stack.pop() + carry)/10;
            
			tempPointer = appendNode(sum, tempPointer);
			
		}
        
		if(carry!=0) {
			tempPointer = appendNode(carry, tempPointer);
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
