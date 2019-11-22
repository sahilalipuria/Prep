/**
 * 
 */
package sorting;

import java.util.Random;

/**
 * @author salipuri
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. 
 * It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. 
 * The merge() function is used for merging two halves. 
 * The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. 
 * See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	
	private int[] nums;
	private int[] tempArray;
	
	public MergeSort(int[] nums) {
		super();
		this.nums = nums;
		tempArray = new int[nums.length];
	}
	
	public void mergeSort(int low,int high) {
		
		if(low>=high)
			return;
		
		int middle = (low+high)/2;
		mergeSort(low, middle);
		mergeSort(middle+1, high);
		merge(low,middle, high);
	}
	

	private void merge(int low, int middle, int high) {
		
		for(int i=low;i<high;i++)
			tempArray[i] = nums[i];
		
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i<=middle && j<=high) {
			if(tempArray[i]<tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			}
			else {
				nums[k] = tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle) {
			nums[k] = tempArray[i];
			i++;
			k++;
		}
		
		while(j<=high) {
			nums[k] = tempArray[j];
			j++;
			k++;
		}
	}
	
	public boolean isSorted(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public void showArray() {
		
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] nums= new int[30];
		
		for(int i=0;i<nums.length;i++) {
			nums[i] = random.nextInt(1000) - 500;
		}
		
		MergeSort mergeSort = new MergeSort(nums);
		mergeSort.mergeSort(0, nums.length-1);
		mergeSort.showArray();

	}

}
