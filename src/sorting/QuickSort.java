/**
 * 
 */
package sorting;

/**
 * @author salipuri
 * 
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. 
 * It picks an element as pivot and partitions the given array around the picked pivot. 
 * There are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). 
Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. 
All this should be done in linear time.

Illustration of partition() :

arr[] = {10, 80, 30, 90, 40, 50, 70}
Indexes:  0   1   2   3   4   5   6 

low = 0, high =  6, pivot = arr[h] = 70
Initialize index of smaller element, i = -1

Traverse elements from j = low to high-1
j = 0 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 0 
arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j 
                                     // are same

j = 1 : Since arr[j] > pivot, do nothing
// No change in i and arr[]

j = 2 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 1
arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30 

j = 3 : Since arr[j] > pivot, do nothing
// No change in i and arr[]

j = 4 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 2
arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
j = 5 : Since arr[j] <= pivot, do i++ and swap arr[i] with arr[j] 
i = 3 
arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped 

We come out of loop because j is now equal to high-1.
Finally we place pivot at correct position by swapping
arr[i+1] and arr[high] (or pivot) 
arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped 

Now 70 is at its correct place. All elements smaller than
70 are before it and all elements greater than 70 are after
it.

Why MergeSort is preferred over QuickSort for Linked Lists?
In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. 
Unlike arrays, linked list nodes may not be adjacent in memory. 
Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. 
Therefore merge operation of merge sort can be implemented without extra space for linked lists.

In arrays, we can do random access as elements are continuous in memory. 
Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). 
Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. 
In linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. 
Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low.
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	
	private int[] nums;
	
	public QuickSort(int[] nums) {
		super();
		this.nums = nums;
	}

	private void swap(int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private int partition(int low,int high) {
		
		int pivotIndex = (low+high)/2;
		swap(pivotIndex, high);
		
		int i = low;
		
		for(int j=low;j<high;j++) {
			
			if(nums[j]<=nums[high]) {
				
				swap(i, j);
				i++;
			}
		}
		
		swap(i, high);
		
		return i;
	}
	
	private void quicksort(int low,int high) {
		
		if(low>=high) return;
		
		int pivot = partition(low, high);
		quicksort(low, pivot-1);
		quicksort(pivot+1, high);
	}
	
	public void sort() {
		quicksort(0, nums.length-1);
	}
	
	public static void showArray(int[] nums) {
		
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {12,-4,56,0,3,8,2,1};
		QuickSort quickSort = new QuickSort(nums);
		quickSort.sort();
		quickSort.showArray(nums);
	}

}
