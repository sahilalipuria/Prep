/**
 * 
 */
package dynammicProgramming;

/**
 * @author salipuri
 * 
 * Objective: The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence in a given array such that all elements of the subsequence are sorted in increasing order.

OR

Given a array A[1,2,……,n] , calculate B[1,2….m] with B[i]Example:

int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };

length of LIS is 7 and LIS is {1, 12, 23, 52, 61, 69, 70}.
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	
	private int[] array;
	private int lisLength;
	private String[] dpTable;
	
	public LongestIncreasingSubsequence(int[] array, int lisLength) {
		super();
		this.array = array;
		this.lisLength = lisLength;
		this.dpTable = new String[lisLength+1];
	}
	
	public void solve() {
		int currentMaxIndex=0;
		int currentDpIndex =0;
		
		dpTable[0] = "" + array[0];
		for(int i=1;currentDpIndex<lisLength-1 && i<array.length;i++) {
			if(array[i]>= array[currentMaxIndex]) {
				currentDpIndex++;
				dpTable[currentDpIndex] = dpTable[currentDpIndex-1]+","+array[i];
				currentMaxIndex = i;
			}
		}
	}

	public void showResults() {
		System.out.println(dpTable[lisLength-1]);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence(A, 7);
		longestIncreasingSubsequence.solve();
		longestIncreasingSubsequence.showResults();
	}

}
