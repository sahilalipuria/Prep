/**
 * 
 */
package binaryHeap;

/**
 * @author salipuri
 * 
 * A binary heap is a heap data structure created using a binary tree.

binary tree has two rules –

Binary Heap has to be complete binary tree at all levels except the last level. This is called shape property.
All nodes are either greater than equal to (Max-Heap) or less than equal to (Min-Heap) to each of its child nodes. This is called heap property.
Implementation:

Use array to store the data.
Start storing from index 1, not 0.
For any given node at position i:
Its Left Child is at [2*i] if available.
Its Right Child is at [2*i+1] if available.
Its Parent Node is at [i/2]if available

Heap Majorly has 3 operations –

Insert Operation
Delete Operation
Extract-Min (OR Extract-Max)
Insert Operation:

Add the element at the bottom leaf of the Heap.
Perform the Bubble-Up operation.
All Insert Operations must perform the bubble-up operation(it is also called as up-heap, percolate-up, sift-up, trickle-up, heapify-up, or cascade-up)
Bubble-up Operation:

If inserted element is smaller than its parent node in case of Min-Heap OR greater than its parent node in case of Max-Heap, swap the element with its parent.
Keep repeating the above step, if node reaches its correct position, STOP.
 

Insert() - Bubble-Up Min-Heap
Insert() – Bubble-Up Min-Heap

Extract-Min OR Extract-Max Operation:

Take out the element from the root.( it will be minimum in case of Min-Heap and maximum in case of Max-Heap).
Take out the last element from the last level from the heap and replace the root with the element.
Perform Sink-Down
All delete operation must perform Sink-Down Operation ( also known as bubble-down, percolate-down, sift-down, trickle down, heapify-down, cascade-down).

Sink-Down Operation:
If replaced element is greater than any of its child node in case of Min-Heap OR smaller than any if its child node in case of Max-Heap, swap the element with its smallest child(Min-Heap) or with its greatest child(Max-Heap).
Keep repeating the above step, if node reaches its correct position, STOP.
Delete OR Extract Min from Heap
Delete OR Extract Min from Heap

Delete Operation:

Find the index for the element to be deleted.
Take out the last element from the last level from the heap and replace the index with this element .
Perform Sink-Down
 *
 */
public class Heap {
	
	private int[] heap;
	private int currentPosition = -1;

	public Heap(int size) {
		this.heap = new int[size];
	}
	
	public void insert(int item) {
		
		if(isFull()) {
			throw new RuntimeException("Heap is full.......");
		}
		
		this.heap[++currentPosition] = item;
		fixup(currentPosition);
	}

	private void fixup(int index) {
		
		int parentIndex = (index-1)/2;
		
		while(parentIndex>=0 && this.heap[parentIndex] < this.heap[index]) {
			int temp = this.heap[parentIndex];
			this.heap[parentIndex] = this.heap[index];
			this.heap[index] = temp;
			index = parentIndex;
			parentIndex = (index-1)/2;
			
		}
		
	}
	
	public int getMax() {
		int result = this.heap[0];
		
		this.heap[0] = this.heap[currentPosition--];
		this.heap[currentPosition+1] = null;
		fixDown(0,-1);
		
		return result;
	}
	
	public void heapSort() {
		
		for(int i=0;i<=currentPosition;i++) {
			int temp = heap[0];
			System.out.println(" "+temp);
			heap[0] = heap[currentPosition-i];
			heap[currentPosition-i] = temp;
			fixDown(0, currentPosition-i-1);
		}
	}

	private void fixDown(int index, int upto) {
		
		if(upto<0)
			upto = currentPosition;
		
		while(index<=upto) {
			int leftChild = 2*index+1;
			int rightChild = 2*index+2;
			
			if(leftChild <= upto) {
				int childSwap;
				
				if(rightChild > upto)
					childSwap = leftChild;
				else
					childSwap = (heap[leftChild] > heap[rightChild])?leftChild:rightChild;
				
				if(heap[index]<heap[childSwap]) {
					int temp = heap[index];
					heap[index] = heap[childSwap];
					heap[childSwap] = temp;
				}else
					break;
				
				index =childSwap;
			}else
				break;
		}
		
	}

	private boolean isFull() {
		return currentPosition == this.heap.length;
	}

}
