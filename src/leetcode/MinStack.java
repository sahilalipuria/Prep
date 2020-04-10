/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author salipuri
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]


Explanation:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 *
 */

class MinStack {

	Stack<Integer> actualStack;
	PriorityQueue<Integer> minHeap;
    
    public MinStack() {
        
    	actualStack = new Stack<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int x) {
        
    	actualStack.add(x);
        minHeap.add(x);
    }
    
    public void pop() {
        
    	int element = actualStack.peek();
    	actualStack.pop();
    	minHeap.remove(element);
        
    }
    
    public int top() {
        return actualStack.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}


/** Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */